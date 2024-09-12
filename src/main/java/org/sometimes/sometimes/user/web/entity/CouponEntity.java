package org.sometimes.sometimes.user.web.entity;

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
@Table(name = "coupon_table")
public class CouponEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "쿠폰 고유 ID", example = "1")
    private Long couponCid;

    @Schema(description = "할인율", example = "20")
    private Integer discount;

    @Schema(description = "시작일", example = "20240901")
    private Integer startDate;

    @Schema(description = "만료일", example = "20240930")
    private Integer dueDate;
}
