package org.sometimes.sometimes.global.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.global.repository.ImageRepository;
import org.sometimes.sometimes.global.web.entity.ImageEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageUploadService {

    // CONFIG
    private final AmazonS3 amazonS3;

    // REPOSITORY
    private final ImageRepository imageRepository;


    @Value("${cloud.aws.s3.bucketName}")
    private String bucketName;

    /**
     * 이미지를 Amazon S3에 업로드합니다.
     *
     * @param image 업로드할 이미지 파일을 나타내는 MultipartFile
     * @param folderName 이미지가 저장될 S3 폴더 이름
     * @return 업로드된 이미지의 URL
     * @throws ImageUploadExeception 업로드 중 IOException이 발생할 경우
     */
    private String uploadImageToS3(MultipartFile image, String folderName) {
        String originName = image.getOriginalFilename();
        String ext = originName.substring(originName.lastIndexOf("."));
        String changedName = folderName + "/" + changedImageName(ext);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(Mimetypes.getInstance().getMimetype(changedName));

        try{
            byte[] bytes = IOUtils.toByteArray(image.getInputStream());
            metadata.setContentLength(bytes.length);
            ByteArrayInputStream byteArrayIs = new ByteArrayInputStream(bytes);

            PutObjectResult putObjectResult = amazonS3.putObject(new PutObjectRequest(
                    bucketName, changedName, byteArrayIs, metadata
            ).withCannedAcl(CannedAccessControlList.PublicRead));
            log.info("[UploadToS3] s3에 이미지가 업로드 되었습니다. resultUrl = " + putObjectResult);
        } catch (IOException e){
            throw new ImageUploadExeception();
        }

        return amazonS3.getUrl(bucketName, changedName).toString();
    }

    /**
     * 신청서 이미지 업로드
     *
     * @param facePhotos 얼굴 사진 파일
     * @param bodyPhoto 전신 사진 파일
     *
     * @return photosCid 사진 cid
     */
    public List<Long> uploadApplyUserPhoto(List<MultipartFile> facePhotos, MultipartFile bodyPhoto) {

        List<Long> photosCid = new ArrayList<Long>();

        for(MultipartFile image: facePhotos) {
            Long imageCid = uploadApplyPhoto(image, "apply-face-photo");

            photosCid.add(imageCid);
        }

        Long bodyPhotoCid = uploadApplyPhoto(bodyPhoto, "apply-body-photo");

        photosCid.add(bodyPhotoCid);

        return photosCid;
    }

    /**
     * 이미지 업로드 메서드
     *
     * @param image 이미지 파일
     * @param folderName s3 폴더 이름
     *
     * @return cid
     */
    private Long uploadApplyPhoto(MultipartFile image, String folderName) {
        String originName = image.getOriginalFilename();
        String storedImagedPath = uploadImageToS3(image, folderName);

        log.debug("[APPLY-IMAGE] 사진이 s3에 업로드 되었습니다.");

        ImageEntity newImage = ImageEntity.from(originName, storedImagedPath);

        imageRepository.save(newImage);

        return newImage.getImageCid();
    }

    /**
     * 이미지 파일의 새로운 이름을 생성합니다.
     *
     * @param ext 이미지 파일의 확장자
     * @return 생성된 이미지 이름
     */
    private String changedImageName(String ext){
        String random = UUID.randomUUID().toString();
        return random+ext;
    }

    /**
     * 이미지 업로드 실패 시 발생하는 커스텀 예외입니다.
     */
    public class ImageUploadExeception extends RuntimeException{
        public ImageUploadExeception(){
            super("이미지 업로드 오류가 발생하였습니다.");
        }
    }

    /**
     * Amazon S3에서 이미지를 삭제합니다.
     *
     * @param productImagePath 삭제할 이미지의 URL
     */
    public void deleteImage(String productImagePath) {
        String key = extractKey(productImagePath);
        log.info("[test]" + key);
        DeleteObjectRequest deleteRequest = new DeleteObjectRequest(bucketName, key);
        amazonS3.deleteObject(deleteRequest);
    }

    /**
     * 이미지 URL에서 S3 키를 추출합니다.
     *
     * @param productImagePath 이미지의 URL
     * @return 이미지의 S3 키
     */
    private String extractKey(String productImagePath){
        String baseUrl = "https://" + bucketName + ".s3.ap-northeast-2.amazonaws.com/";
        return productImagePath.substring(baseUrl.length());
    }
}
