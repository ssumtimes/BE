package org.sometimes.sometimes.user.web.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.sometimes.sometimes.global.web.entity.TimeEntity;
import org.sometimes.sometimes.global.web.enums.user.AccountStatus;
import org.sometimes.sometimes.global.web.enums.user.Roles;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.Earning;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.Gender;
import org.sometimes.sometimes.user.web.dto.auth.SignupReqDto;

import java.time.LocalDateTime;
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
    @Column(name = "user_id", unique = true)
    private String userId;

    @NotNull
    @Schema(description = "유저 비밀번호", example = "test")
    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "username")
    @Schema(description = "사용자 이름", example = "홍길동")
    private String username;

    @Enumerated(EnumType.STRING)
    @Schema(description = "성별", example = "MALE")
    private Gender gender;

    @Column(name = "phone_number", unique = true)
    @Schema(description = "핸드폰 번호", example = "01012345678")
    private Integer contactNumber;

    @Schema(description = "생일", example = "19900101")
    private Integer birthDate;

    @Schema(description = "주소", example = "서울특별시 강남구")
    private String location;

    @Schema(description = "직업", example = "개발자")
    private String job;

    @Schema(description = "연 소득 구간")
    private Earning incomeRange;

    @Schema(description = "키")
    private Integer height;

    @Schema(description = "이성을 볼때 중요하게 보는 항목")
    private String importantFactors;

    @Schema(description = "sms 수신동의")
    private Boolean agreedToSms;

    @Schema(description = "email 수신동의")
    private Boolean agreedToEmail;

    @Schema(description = "유저 프로필 이미지 cid")
    private Long userProfileImageCid;

    @ElementCollection
    @CollectionTable(name = "user_coupons", joinColumns = @JoinColumn(name = "user_id"))
    @Schema(description = "보유 쿠폰 리스트", example = "[1, 2, 3]")
    @Column(name = "coupon_id")
    private List<Long> couponList;

    @NotNull
    @Schema(description = "계정 삭제 유무", example = "ACTIVE")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Schema(description = "계정 탈퇴 날짜", example = "240101")
    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;

    @NotNull
    @Schema(description = "유저 권한", example = "ROLE_USER")
    @Enumerated(EnumType.STRING)
    private Roles userRole;

    public static UserEntity from(SignupReqDto signupReqDto, String hashedPwd) {
        return UserEntity.builder()
                .userId(signupReqDto.getUserId())
                .userPwd(hashedPwd)
                .username(signupReqDto.getUsername())
                .contactNumber(signupReqDto.getContactNumber())
                .gender(signupReqDto.getGender())
                .birthDate(signupReqDto.getBirthDate())
                .location(signupReqDto.getLocation())
                .job(signupReqDto.getJob())
                .importantFactors(signupReqDto.getImportantFactors())
                .incomeRange(signupReqDto.getIncomeRange())
                .height(signupReqDto.getHeight())
                .importantFactors(signupReqDto.getImportantFactors())
                .accountStatus(AccountStatus.ACTIVE)
                .userRole(Roles.ROLE_USER)
                .build();
    }
}
