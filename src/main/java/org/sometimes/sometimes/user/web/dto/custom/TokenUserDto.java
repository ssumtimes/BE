package org.sometimes.sometimes.user.web.dto.custom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.sometimes.sometimes.user.web.entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TokenUserDto {

    @Schema(description = "유저 아이디", example = "test")
    private String userId;

    @Schema(description = "비밀번호", example = "test")
    private String userPassword;

    @Schema(description = "유저권한", example = "ROLE_USER")
    private String roles;

    public static TokenUserDto toDto(UserEntity userEntity){
        return TokenUserDto.builder()
                .userId(userEntity.getUserId())
                .userPassword(userEntity.getUserPwd())
                .roles(userEntity.getUserRole().getType())
                .build();
    }
}
