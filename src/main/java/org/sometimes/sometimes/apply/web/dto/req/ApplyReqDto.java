package org.sometimes.sometimes.apply.web.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ApplyReqDto {

    @Schema(description = "약관 동의 여부", example = "true")
    private Boolean agreement;

    @Schema(description = "이름", example = "홍길동")
    private String name;

    @Schema(description = "전화번호", example = "01012345678")
    private int phoneNumber;

    @Schema(description = "성별", example = "MALE")
    private String male;

    @Schema(description = "생년월일", example = "19900101")
    private int birth;

    @Schema(description = "주소", example = "서울특별시 강남구 테헤란로 123")
    private String address;

    @Schema(description = "직업", example = "개발자")
    private String job;

    @Schema(description = "회사", example = "ABC Corp")
    private String company;

    @Schema(description = "직무", example = "백엔드 개발")
    private String task;

    @Schema(description = "소득", example = "6000")
    private int earnings;

    @Schema(description = "직업 증빙자료 (파일 경로)", example = "s3://bucket/file.pdf")
    private String employmentVerification;

    @Schema(description = "출신 고등학교", example = "서울고등학교")
    private String highSchool;

    @Schema(description = "전공", example = "컴퓨터 공학")
    private String major;

    @Schema(description = "학위", example = "석사")
    private String doc;

    @Schema(description = "키", example = "180")
    private int height;

    @Schema(description = "체중", example = "70")
    private int weight;

    @Schema(description = "외모 특징", example = "마른 체형, 긴 머리")
    private String physicalCharacteristics;

    @Schema(description = "음주 여부", example = "NO")
    private Drinking drinking;

    @Schema(description = "흡연 여부", example = "NO")
    private Smoking smoking;

    @Schema(description = "종교", example = "NONE")
    private String religion;

    @Schema(description = "기타 종교", example = "천주교")
    private String otherReligion;

    @Schema(description = "종교 참여도", example = "LOW")
    private ReligionParticipation religionParticipation;

    @Schema(description = "취미 또는 관심사", example = "독서, 운동")
    private String hobbiesOrInterests;

    @Schema(description = "성향", example = "내성적")
    private String personality;

    @Schema(description = "가치관", example = "자유로움")
    private String value;

    @Schema(description = "연애 스타일", example = "진지함")
    private String datingStyle;

    @Schema(description = "매력 포인트", example = "차분함, 성실함")
    private String appealPoints;

    @Schema(description = "MBTI", example = "INFJ")
    private MBTI mbti;

    @Schema(description = "가장 중요한 이성의 조건", example = "성격")
    private String mostImportantInPartner;

    @Schema(description = "가장 중요한 조건 설명", example = "성격이 좋아야 관계가 편안합니다.")
    private String explainMostImportant;

    @Schema(description = "두 번째로 중요한 이성의 조건", example = "가치관")
    private String secondMostImportantInPartner;

    @Schema(description = "두 번째 중요한 조건 설명", example = "같은 가치관을 공유할 수 있어야 합니다.")
    private String explainSecondMostImportant;

    @Schema(description = "세 번째로 중요한 이성의 조건", example = "외모")
    private String thirdMostImportantInPartner;

    @Schema(description = "세 번째 중요한 조건 설명", example = "첫인상이 중요하다고 생각합니다.")
    private String explainThirdMostImportant;

    @Schema(description = "덜 중요한 조건 리스트", example = "[\"나이\", \"거주지\"]")
    private List<ImportantInPartner> lessImportantInPartner;

    @Schema(description = "기타 이성의 특징", example = "유머 감각이 뛰어난 사람")
    private String otherPartnerPreferences;

    @Schema(description = "절대 안 되는 이성의 조건", example = "흡연자")
    private String absoluteNoInPartner;

    @Schema(description = "못 먹는 음식", example = "없음")
    private String foodDislikes;

    @Schema(description = "주량", example = "소주 한 병")
    private String drinkingCapacity;

    @Schema(description = "지원 동기", example = "새로운 만남을 기대하고 있습니다.")
    private String applicationMotivation;

    @Schema(description = "추천인 이름 및 전화번호 뒤 4자리", example = "홍길동, 5678")
    private String referrerNameAndPhoneLast4Digits;

    @Schema(description = "약관 동의 여부", example = "true")
    private Boolean agreementOfReuse;

    @Schema(description = "약관 동의 여부", example = "true")
    private Boolean agreementOfReceive;
}