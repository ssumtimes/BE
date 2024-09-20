package org.sometimes.sometimes.apply.service;

import lombok.RequiredArgsConstructor;
import org.sometimes.sometimes.apply.repository.ApplyInfoRepository;
import org.sometimes.sometimes.apply.util.ApplyValidation;
import org.sometimes.sometimes.apply.web.dto.req.ApplyReqDto;
import org.sometimes.sometimes.apply.web.entity.ApplyInfoEntity;
import org.sometimes.sometimes.global.aws.ImageUploadService;
import org.sometimes.sometimes.user.util.UserValidation;
import org.sometimes.sometimes.user.web.entity.UserEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyService {

    // REPOSITORY
    private final ApplyInfoRepository applyInfoRepository;

    // UTIL
    private final UserValidation userValidation;
    private final ApplyValidation applyValidation;
    private final ImageUploadService imageUploadService;

    /**
     * 지원서를 생성하는 메서드.
     *
     * 1. 클라이언트로부터 받은 지원서 데이터를 검증합니다.
     * 2. 유저 정보가 유효한지 확인합니다.
     * 3. 얼굴 사진과 전신 사진을 업로드하고, 그 결과로 받은 CID 리스트를 저장합니다.
     * 4. 지원서 정보를 데이터베이스에 저장합니다.
     *
     * @param user 현재 로그인된 사용자 정보
     * @param applyReqDto 지원서에 대한 입력 데이터 (DTO)
     * @param facePhotos 얼굴 사진 리스트 (여러 장의 이미지 파일)
     * @param bodyPhoto 전신 사진 (단일 이미지 파일)
     */
    @Transactional
    public void createApply(User user, ApplyReqDto applyReqDto, List<MultipartFile> facePhotos, MultipartFile bodyPhoto) {

        applyValidation.validateFormData(applyReqDto, facePhotos, bodyPhoto);

        userValidation.validateExistUser(user.getUsername());

        List<Long> photosCid = imageUploadService.uploadApplyUserPhoto(facePhotos, bodyPhoto);

        applyInfoRepository.save(ApplyInfoEntity.from(applyReqDto, photosCid));
    }
}