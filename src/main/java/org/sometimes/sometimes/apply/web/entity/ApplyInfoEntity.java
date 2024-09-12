package org.sometimes.sometimes.apply.web.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.sometimes.sometimes.global.web.entity.ImageEntity;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.*;

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

    @Column(nullable = false)
    @Schema(description = "약관 동의 여부", required = true, example = "true")
    private boolean agreement;

    @Column(nullable = false, length = 100)
    @Schema(description = "이름", required = true, example = "홍길동")
    private String name;

    @Column(nullable = false)
    @Schema(description = "전화번호", required = true, example = "01012345678")
    private int phoneNumber;

    @Column(nullable = false)
    @Schema(description = "성별", required = true, example = "MALE")
    private String male;

    @Column(nullable = false)
    @Schema(description = "생년월일", required = true, example = "19900101")
    private int birth;

    @Column(nullable = false, length = 255)
    @Schema(description = "주소", required = true, example = "서울특별시 강남구 테헤란로 123")
    private String address;

    @Column(nullable = false, length = 100)
    @Schema(description = "직업", required = true, example = "개발자")
    private String job;

    @Column(nullable = false, length = 100)
    @Schema(description = "회사", required = true, example = "ABC Corp")
    private String company;

    @Column(nullable = false, length = 100)
    @Schema(description = "직무", required = true, example = "백엔드 개발")
    private String task;

    @Column(nullable = false)
    @Schema(description = "소득", required = true, example = "6000")
    private int earnings;

    @Column(nullable = false, length = 255)
    @Schema(description = "직업 증빙자료 (파일 경로)", required = true, example = "s3://bucket/file.pdf")
    private String employmentVerification;

    @Column(length = 100)
    @Schema(description = "출신 고등학교", example = "서울고등학교")
    private String highSchool;

    @Column(length = 100)
    @Schema(description = "전공", example = "컴퓨터 공학")
    private String major;

    @Column(length = 100)
    @Schema(description = "학위", example = "석사")
    private String doc;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facePhoto1")
    @Schema(description = "얼굴 사진 1")
    private ImageEntity facePhoto1;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facePhoto2")
    @Schema(description = "얼굴 사진 2")
    private ImageEntity facePhoto2;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bodyPhoto")
    @Schema(description = "전신 사진")
    private ImageEntity bodyPhoto;

    @Schema(description = "키", example = "180")
    private int height;

    @Schema(description = "체중", example = "70")
    private int weight;

    @Column(length = 255)
    @Schema(description = "외모 특징", example = "마른 체형, 긴 머리")
    private String physicalCharacteristics;

    @Enumerated(EnumType.STRING)
    @Schema(description = "음주 여부", example = "NO")
    private Drinking drinking;

    @Enumerated(EnumType.STRING)
    @Schema(description = "흡연 여부", example = "NO")
    private Smoking smoking;

    @Schema(description = "종교", example = "NONE")
    private String religion;

    @Column(length = 100)
    @Schema(description = "기타 종교", example = "천주교")
    private String otherReligion;

    @Enumerated(EnumType.STRING)
    @Schema(description = "종교 참여도", example = "LOW")
    private ReligionParticipation religionParticipation;

    @Column(length = 255)
    @Schema(description = "취미 또는 관심사", example = "독서, 운동")
    private String hobbiesOrInterests;

    @Column(length = 255)
    @Schema(description = "성향", example = "내성적")
    private String personality;

    @Column(length = 255)
    @Schema(description = "가치관", example = "자유로움")
    private String value;

    @Column(length = 255)
    @Schema(description = "연애 스타일", example = "진지함")
    private String datingStyle;

    @Column(length = 255)
    @Schema(description = "매력 포인트", example = "차분함, 성실함")
    private String appealPoints;

    @Enumerated(EnumType.STRING)
    @Schema(description = "MBTI", example = "INFJ")
    private MBTI mbti;

    @Column(length = 255)
    @Schema(description = "가장 중요한 이성의 조건", example = "성격")
    private String mostImportantInPartner;

    @Column(length = 255)
    @Schema(description = "가장 중요한 조건 설명", example = "성격이 좋아야 관계가 편안합니다.")
    private String explainMostImportant;

    @Column(length = 255)
    @Schema(description = "두 번째로 중요한 이성의 조건", example = "가치관")
    private String secondMostImportantInPartner;

    @Column(length = 255)
    @Schema(description = "두 번째 중요한 조건 설명", example = "같은 가치관을 공유할 수 있어야 합니다.")
    private String explainSecondMostImportant;

    @Column(length = 255)
    @Schema(description = "세 번째로 중요한 이성의 조건", example = "외모")
    private String thirdMostImportantInPartner;

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

    @Column(length = 255)
    @Schema(description = "못 먹는 음식", example = "없음")
    private String foodDislikes;

    @Column(length = 255)
    @Schema(description = "주량", example = "소주 한 병")
    private String drinkingCapacity;

    @Column(length = 500)
    @Schema(description = "지원 동기", example = "새로운 만남을 기대하고 있습니다.")
    private String applicationMotivation;

    @Column(length = 100)
    @Schema(description = "추천인 이름 및 전화번호 뒤 4자리", example = "홍길동, 5678")
    private String referrerNameAndPhoneLast4Digits;
}
