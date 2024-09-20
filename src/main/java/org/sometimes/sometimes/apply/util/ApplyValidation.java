package org.sometimes.sometimes.apply.util;

import lombok.RequiredArgsConstructor;
import org.sometimes.sometimes.apply.web.dto.req.ApplyReqDto;
import org.sometimes.sometimes.global.web.advice.exception.CustomDataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplyValidation {

    /**
     * 입력 받은 데이터 유효성 검사
     *
     * @param applyReqDto 입력된 정보
     * @param facePhotos 얼굴 사진 파일
     * @param bodyPhoto 전신 사진 파일
     */
    public void validateFormData(ApplyReqDto applyReqDto, List<MultipartFile> facePhotos, MultipartFile bodyPhoto) {
        // not-null 체크
        validateNotNull(applyReqDto.getAgreement(), "약관 동의 여부는 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getName(), "이름은 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getPhoneNumber(), "전화번호는 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getMale(), "성별은 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getBirth(), "생년월일은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getAddress(), "주소는 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getJob(), "직업은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getCompany(), "회사는 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getTask(), "직무는 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getEarnings(), "소득은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getEmploymentVerification(), "직업 증빙 자료는 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getHeight(), "키는 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getWeight(), "체중은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getPhysicalCharacteristics(), "외모 특징은 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getDrinking(), "음주 여부는 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getSmoking(), "흡연 여부는 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getReligion(), "종교는 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getReligionParticipation(), "종교 참여도는 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getHobbiesOrInterests(), "취미 또는 관심사는 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getPersonality(), "성향은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getValue(), "가치관은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getDatingStyle(), "연애 스타일은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getAppealPoints(), "매력 포인트는 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getMostImportantInPartner(), "가장 중요한 이성의 조건은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getExplainMostImportant(), "가장 중요한 조건 설명은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getSecondMostImportantInPartner(), "두 번째로 중요한 이성의 조건은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getExplainSecondMostImportant(), "두 번째 중요한 조건 설명은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getThirdMostImportantInPartner(), "세 번째로 중요한 이성의 조건은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getExplainThirdMostImportant(), "세 번째 중요한 조건 설명은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getFoodDislikes(), "못 먹는 음식은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getDrinkingCapacity(), "주량은 필수 입력 값입니다.");
        validateNotEmpty(applyReqDto.getApplicationMotivation(), "지원 동기는 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getAgreementOfReuse(), "신청서 재사용 동의 여부는 필수 입력 값입니다.");
        validateNotNull(applyReqDto.getAgreementOfReceive(), "수신 동의 여부는 필수 입력 값입니다.");

        // 이미지 파일 검증
        validateImagesNotEmpty(facePhotos, "얼굴 사진은 필수 입력 항목입니다.");
        validateImageNotEmpty(bodyPhoto, "전신 사진은 필수 입력 항목입니다.");
    }

    /**
     * 필드 값이 null인지 확인하는 메서드.
     *
     * @param value 검사할 필드 값
     * @param errorMessage 검증 실패 시 발생할 예외 메시지
     */
    private void validateNotNull(Object value, String errorMessage) {
        if (value == null) {
            throw new CustomDataIntegrityViolationException(errorMessage);
        }
    }

    /**
     * 문자열 필드 값이 null이거나 비어있는지 확인하는 메서드.
     *
     * @param value 검사할 문자열 필드 값
     * @param errorMessage 검증 실패 시 발생할 예외 메시지
     */
    private void validateNotEmpty(String value, String errorMessage) {
        if (value == null || value.trim().isEmpty()) {
            throw new CustomDataIntegrityViolationException(errorMessage);
        }
    }

    /**
     * 다수의 이미지 파일이 null이거나 비어있는지 확인하는 메서드.
     *
     * @param files 검사할 이미지 파일 리스트
     * @param errorMessage 검증 실패 시 발생할 예외 메시지
     */
    private void validateImagesNotEmpty(List<MultipartFile> files, String errorMessage) {
        if (files == null || files.isEmpty()) {
            throw new CustomDataIntegrityViolationException(errorMessage);
        }
        for (MultipartFile file : files) {
            validateImageNotEmpty(file, errorMessage);
        }
    }

    /**
     * 단일 이미지 파일이 null이거나 비어있는지 확인하는 메서드.
     *
     * @param file 검사할 단일 이미지 파일
     * @param errorMessage 검증 실패 시 발생할 예외 메시지
     */
    private void validateImageNotEmpty(MultipartFile file, String errorMessage) {
        if (file == null || file.isEmpty()) {
            throw new CustomDataIntegrityViolationException(errorMessage);
        }
    }
}