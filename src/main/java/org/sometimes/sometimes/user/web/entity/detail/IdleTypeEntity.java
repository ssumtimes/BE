package org.sometimes.sometimes.user.web.entity.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.ImportantInPartner;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "idle_type_table")
public class IdleTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "이상형 고유 ID", example = "1")
    private Long idealTypeCid;

    @Schema(description = "연애 스타일", example = "Romantic")
    private String datingStyle;

    @Enumerated(EnumType.STRING)
    @Schema(description = "이성을 보는 제일 중요한 사항", example = "Personality")
    private ImportantInPartner mostImportantInPartner;

    @Schema(description = "제일 중요한 이유", example = "Personality defines character")
    private String explainMostImportant;

    @Enumerated(EnumType.STRING)
    @Schema(description = "이성을 보는 두번째 중요한 사항", example = "Appearance")
    private ImportantInPartner secondMostImportantInPartner;

    @Schema(description = "두번째 중요한 이유", example = "Appearance matters")
    private String explainSecondMostImportant;

    @Enumerated(EnumType.STRING)
    @Schema(description = "이성을 보는 세번째 중요한 사항", example = "Career")
    private ImportantInPartner thirdMostImportantInPartner;

    @Schema(description = "세번째 중요한 이유", example = "Career stability")
    private String explainThirdMostImportant;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Schema(description = "이성을 볼때 중요하지 않은 사항들", example = "[\"Religion\", \"Hobbies\"]")
    private List<ImportantInPartner> lessImportantInPartner;

    @Schema(description = "만나고 싶은 사람의 특징", example = "Open-minded")
    private String otherPartnerPreferences;

    @Schema(description = "만나고 싶은 사람에게 절대 안 되는 사항", example = "Smoking")
    private String absoluteNoInPartner;
}
