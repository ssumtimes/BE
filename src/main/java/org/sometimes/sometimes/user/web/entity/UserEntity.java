package org.sometimes.sometimes.user.web.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.sometimes.sometimes.global.web.entity.TimeEntity;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.Gender;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "user_table")
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "사용자 고유 ID", example = "1")
    private Long userCid;

    @NotNull
    @Schema(description = "유저 아이디", example = "test")
    @Column(name = "user_id")
    private String userId;

    @NotNull
    @Schema(description = "유저 비밀번호", example = "test")
    @Column(name = "user_pwd")
    private String userPwd;

    @Column(nullable = false)
    @Schema(description = "사용자 이름", example = "홍길동")
    private Integer username;

    @Column(nullable = false, unique = true)
    @Schema(description = "핸드폰 번호", example = "01012345678")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Schema(description = "성별", example = "MALE")
    private Gender gender;

    @Schema(description = "생일", example = "19900101")
    private Integer birth;

    @Schema(description = "주소", example = "서울특별시 강남구")
    private String address;

    @Schema(description = "직업", example = "개발자")
    private String job;

    @ElementCollection
    @CollectionTable(name = "user_coupons", joinColumns = @JoinColumn(name = "user_id"))
    @Schema(description = "보유 쿠폰 리스트", example = "[1, 2, 3]")
    @Column(name = "coupon_id")
    private List<Long> couponList;
}
