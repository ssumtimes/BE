package org.sometimes.sometimes.content.web.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.sometimes.sometimes.global.web.entity.TimeEntity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "content_table")
public class ContentEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "컨텐츠 고유 ID", example = "1")
    private Long contentCid;

    @Schema(description = "타이틀 이미지 CID")
    private Long contentTitleImgCid;

    @Schema(description = "컨텐츠 제목")
    private String contentTitle;

    @Schema(description = "컨텐츠 부제목")
    private String contentSubTitle;

    @Schema(description = "컨텐츠 롱 타이틀")
    private String contentLongTitle;

    @Schema(description = "컨텐츠 대상자 나이")
    private String contentTargetAge;

    @Schema(description = "컨텐츠 대상자 인원")
    private Integer contentTargetCnt;

    @Schema(description = "컨텐츠 장소")
    private String contentLocation;

    @Schema(description = "컨텐츠 가격")
    private Integer contentPrice;

    @Schema(description = "남자 할인률")
    private Integer maleDiscount;
}
