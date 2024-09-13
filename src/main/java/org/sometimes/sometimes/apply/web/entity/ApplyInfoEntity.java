package org.sometimes.sometimes.apply.web.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.sometimes.sometimes.apply.web.dto.req.ApplyReqDto;
import org.sometimes.sometimes.global.web.entity.ImageEntity;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "apply_info_table")
public class ApplyInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "지원서 ID", example = "1")
    private Long applyFormCid;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "약관 동의 여부", example = "true")
    private boolean agreement;

    @NotNull
    @Column(nullable = false, length = 100)
    @Schema(description = "이름", example = "홍길동")
    private String name;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "전화번호", example = "01012345678")
    private int phoneNumber;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "성별", example = "MALE")
    private String male;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "생년월일", example = "19900101")
    private int birth;

    @NotNull
    @Column(nullable = false, length = 255)
    @Schema(description = "주소", example = "서울특별시 강남구 테헤란로 123")
    private String address;

    @NotNull
    @Column(nullable = false, length = 100)
    @Schema(description = "직업", example = "개발자")
    private String job;

    @NotNull
    @Column(nullable = false, length = 100)
    @Schema(description = "회사", example = "ABC Corp")
    private String company;

    @NotNull
    @Column(nullable = false, length = 100)
    @Schema(description = "직무", example = "백엔드 개발")
    private String task;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "소득", example = "6000")
    private int earnings;

    @NotNull
    @Column(nullable = false, length = 255)
    @Schema(description = "직업 증빙자료 (파일 경로)", example = "s3://bucket/file.pdf")
    private String employmentVerification;

    @NotNull
    @Column(length = 100)
    @Schema(description = "출신 고등학교", example = "서울고등학교")
    private String highSchool;

    @NotNull
    @Column(length = 100)
    @Schema(description = "전공", example = "컴퓨터 공학")
    private String major;

    @Column(length = 100)
    @Schema(description = "학위", example = "석사")
    private String doc;

    @Schema(description = "얼굴 사진 1")
    private Long facePhoto1Cid;

    @Schema(description = "얼굴 사진 2")
    private Long facePhoto2Cid;

    @Schema(description = "전신 사진")
    private Long bodyPhoto;

    @NotNull
    @Schema(description = "키", example = "180")
    private int height;

    @NotNull
    @Schema(description = "체중", example = "70")
    private int weight;

    @NotNull
    @Column(length = 255)
    @Schema(description = "외모 특징", example = "마른 체형, 긴 머리")
    private String physicalCharacteristics;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Schema(description = "음주 여부", example = "NO")
    private Drinking drinking;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Schema(description = "흡연 여부", example = "NO")
    private Smoking smoking;

    @NotNull
    @Schema(description = "종교", example = "NONE")
    private String religion;

    @Column(length = 100)
    @Schema(description = "기타 종교", example = "천주교")
    private String otherReligion;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Schema(description = "종교 참여도", example = "LOW")
    private ReligionParticipation religionParticipation;

    @NotNull
    @Column(length = 255)
    @Schema(description = "취미 또는 관심사", example = "독서, 운동")
    private String hobbiesOrInterests;

    @NotNull
    @Column(length = 255)
    @Schema(description = "성향", example = "내성적")
    private String personality;

    @NotNull
    @Column(length = 255)
    @Schema(description = "가치관", example = "자유로움")
    private String value;

    @NotNull
    @Column(length = 255)
    @Schema(description = "연애 스타일", example = "진지함")
    private String datingStyle;

    @NotNull
    @Column(length = 255)
    @Schema(description = "매력 포인트", example = "차분함, 성실함")
    private String appealPoints;

    @Enumerated(EnumType.STRING)
    @Schema(description = "MBTI", example = "INFJ")
    private MBTI mbti;

    @NotNull
    @Column(length = 255)
    @Schema(description = "가장 중요한 이성의 조건", example = "성격")
    private String mostImportantInPartner;

    @NotNull
    @Column(length = 255)
    @Schema(description = "가장 중요한 조건 설명", example = "성격이 좋아야 관계가 편안합니다.")
    private String explainMostImportant;

    @NotNull
    @Column(length = 255)
    @Schema(description = "두 번째로 중요한 이성의 조건", example = "가치관")
    private String secondMostImportantInPartner;

    @NotNull
    @Column(length = 255)
    @Schema(description = "두 번째 중요한 조건 설명", example = "같은 가치관을 공유할 수 있어야 합니다.")
    private String explainSecondMostImportant;

    @NotNull
    @Column(length = 255)
    @Schema(description = "세 번째로 중요한 이성의 조건", example = "외모")
    private String thirdMostImportantInPartner;

    @NotNull
    @Column(length = 255)
    @Schema(description = "세 번째 중요한 조건 설명", example = "첫인상이 중요하다고 생각합니다.")
    private String explainThirdMostImportant;

    @ElementCollection
    @CollectionTable(name = "less_important_in_partner", joinColumns = @JoinColumn(name = "applyFormCid"))
    @Column(name = "less_important_partner")
    @Schema(description = "덜 중요한 조건 리스트", example = "[\"나이\", \"거주지\"]")
    private List<ImportantInPartner> lessImportantInPartner;

    @Column(length = 255)
    @Schema(description = "기타 이성의 특징", example = "유머 감각이 뛰어난 사람")
    private String otherPartnerPreferences;

    @Column(length = 255)
    @Schema(description = "절대 안 되는 이성의 조건", example = "흡연자")
    private String absoluteNoInPartner;

    @NotNull
    @Column(length = 255)
    @Schema(description = "못 먹는 음식", example = "없음")
    private String foodDislikes;

    @NotNull
    @Column(length = 255)
    @Schema(description = "주량", example = "소주 한 병")
    private String drinkingCapacity;

    @NotNull
    @Column(length = 500)
    @Schema(description = "지원 동기", example = "새로운 만남을 기대하고 있습니다.")
    private String applicationMotivation;

    @Column(length = 100)
    @Schema(description = "추천인 이름 및 전화번호 뒤 4자리", example = "홍길동, 5678")
    private String referrerNameAndPhoneLast4Digits;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "신청서 재사용 동의 여부", example = "true")
    private boolean agreementOfReuse;

    @NotNull
    @Column(nullable = false)
    @Schema(description = "수신 동의 여부", example = "true")
    private boolean agreementOfReceive;

    public static ApplyInfoEntity from(ApplyReqDto applyReqDto, List<Long> photoCid) {
    return ApplyInfoEntity.builder()
            .agreement(applyReqDto.getAgreement())
            .name(applyReqDto.getName())
            .phoneNumber(applyReqDto.getPhoneNumber())
            .male(applyReqDto.getMale())
            .birth(applyReqDto.getBirth())
            .address(applyReqDto.getAddress())
            .job(applyReqDto.getJob())
            .company(applyReqDto.getCompany())
            .task(applyReqDto.getTask())
            .earnings(applyReqDto.getEarnings())
            .employmentVerification(applyReqDto.getEmploymentVerification())
            .highSchool(applyReqDto.getHighSchool())
            .male(applyReqDto.getMajor())
            .doc(applyReqDto.getDoc() != null ? applyReqDto.getDoc() : null)
            .facePhoto1Cid(photoCid.get(0))
            .facePhoto2Cid(photoCid.get(1))
            .bodyPhoto(photoCid.get(2))
            .height(applyReqDto.getHeight())
            .weight(applyReqDto.getWeight())
            .physicalCharacteristics(applyReqDto.getPhysicalCharacteristics())
            .drinking(applyReqDto.getDrinking())
            .smoking(applyReqDto.getSmoking())
            .religion(applyReqDto.getReligion())
            .otherReligion(applyReqDto.getOtherReligion())
            .religionParticipation(applyReqDto.getReligionParticipation())
            .hobbiesOrInterests(applyReqDto.getHobbiesOrInterests())
            .personality(applyReqDto.getPersonality())
            .value(applyReqDto.getValue())
            .datingStyle(applyReqDto.getDatingStyle())
            .appealPoints(applyReqDto.getAppealPoints())
            .mbti(applyReqDto.getMbti())
            .mostImportantInPartner(applyReqDto.getMostImportantInPartner())
            .explainMostImportant(applyReqDto.getExplainMostImportant())
            .secondMostImportantInPartner(applyReqDto.getSecondMostImportantInPartner())
            .explainSecondMostImportant(applyReqDto.getExplainSecondMostImportant())
            .thirdMostImportantInPartner(applyReqDto.getThirdMostImportantInPartner())
            .explainThirdMostImportant(applyReqDto.getExplainThirdMostImportant())
            .lessImportantInPartner(applyReqDto.getLessImportantInPartner())
            .otherPartnerPreferences(applyReqDto.getOtherPartnerPreferences() != null ? applyReqDto.getOtherPartnerPreferences() : null)
            .absoluteNoInPartner(applyReqDto.getAbsoluteNoInPartner() != null ? applyReqDto.getAbsoluteNoInPartner() : null)
            .foodDislikes(applyReqDto.getFoodDislikes())
            .drinkingCapacity(applyReqDto.getDrinkingCapacity())
            .applicationMotivation(applyReqDto.getApplicationMotivation())
            .referrerNameAndPhoneLast4Digits(applyReqDto.getReferrerNameAndPhoneLast4Digits() != null ? applyReqDto.getReferrerNameAndPhoneLast4Digits() : null)
            .agreementOfReuse(applyReqDto.getAgreementOfReuse())
            .agreementOfReceive(applyReqDto.getAgreementOfReceive())
            .build();
    }
}
