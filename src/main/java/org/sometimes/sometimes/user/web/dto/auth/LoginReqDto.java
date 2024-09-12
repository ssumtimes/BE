package org.sometimes.sometimes.user.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class LoginReqDto {

    @Schema(description = "유저 아이디", example = "test")
    private String userId;

    @Schema(description = "비밀번호", example = "test")
    private String userPassword;

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(userId, userPassword);
    }
}