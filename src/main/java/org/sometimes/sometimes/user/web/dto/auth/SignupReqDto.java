package org.sometimes.sometimes.user.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.Earning;
import org.sometimes.sometimes.global.web.enums.userInfoDetail.Gender;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SignupReqDto {

    @Schema(description = "유저 아이디", example = "test")
    private String userId;

    @Schema(description = "유저 비밀번호", example = "test")
    private String userPwd;

    @Schema(description = "사용자 이름", example = "홍길동")
    private String username;

    @Schema(description = "핸드폰 번호", example = "01012345678")
    private Integer contactNumber;

    @Schema(description = "성별", example = "MALE")
    private Gender gender;

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
}
