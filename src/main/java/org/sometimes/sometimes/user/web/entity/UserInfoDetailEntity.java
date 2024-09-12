package org.sometimes.sometimes.user.web.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "user_info_detail_table")
public class UserInfoDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "사용자 세부 정보 고유 ID", example = "1")
    private Long userDetailCid;

    @Schema(description = "회사", example = "Google")
    private String company;

    @Schema(description = "직무", example = "Software Engineer")
    private String task;

    @Schema(description = "직업 증빙자료 (AWS에 파일 저장)", example = "employment_verification.pdf")
    private String employmentVerification;

    @Schema(description = "소득", example = "50000")
    private Integer earning;

    @Schema(description = "고등학교", example = "Seoul High School")
    private String highSchool;

    @Schema(description = "대학교", example = "Korea University")
    private String university;

    @Schema(description = "전공", example = "Computer Science")
    private String major;

    @Schema(description = "키", example = "180")
    private Integer height;

    @Schema(description = "체중", example = "70")
    private Integer weight;

    @Schema(description = "외모 특징", example = "Tall and athletic")
    private String physicalCharacteristics;

    @Enumerated(EnumType.STRING)
    @Schema(description = "음주 여부", example = "YES")
    private Drinking drinking;

    @Enumerated(EnumType.STRING)
    @Schema(description = "흡연 여부", example = "NO")
    private Smoking smoking;

    @Enumerated(EnumType.STRING)
    @Schema(description = "종교", example = "CHRISTIAN")
    private ImportantInPartner religion;

    @Schema(description = "기타 종교", example = "None")
    private String otherReligion;

    @Enumerated(EnumType.STRING)
    @Schema(description = "종교 참여도", example = "OFTEN")
    private ReligionParticipation religionParticipation;

    @Schema(description = "취미 & 관심사", example = "Reading, Hiking")
    private String hobbies;

    @Schema(description = "성향", example = "Introverted")
    private String personality;

    @Schema(description = "가치관", example = "Honesty is key")
    private String descriptions;

    @Schema(description = "자신의 매력 포인트", example = "Sense of humor")
    private String appealPoints;

    @Enumerated(EnumType.STRING)
    @Schema(description = "MBTI", example = "INTJ")
    private MBTI mbti;

    @Schema(description = "못 먹는 음식", example = "Seafood")
    private String foodDislike;

    @Schema(description = "주량", example = "2 bottles of Soju")
    private String drinkingCapacity;

    @Schema(description = "지원 동기", example = "To meet new people")
    private String applicationMotivation;

    @Schema(description = "추천인", example = "John Doe")
    private String referrer;
}
