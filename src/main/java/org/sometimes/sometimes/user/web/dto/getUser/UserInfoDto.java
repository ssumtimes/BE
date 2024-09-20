package org.sometimes.sometimes.user.web.dto.getUser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.sometimes.sometimes.user.web.entity.UserEntity;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserInfoDto {
    @Schema(description = "유저 고유 아이디")
    private Long userCid;

    @Schema(description = "유저 아이디", example = "test")
    private String userId;

    @Schema(description = "유저 이름", example = "홍길동")
    private String userName;

    @Schema(description = "유저 프로필 사진")
    private String profileImgPath;

    public static UserInfoDto from(final UserEntity userEntity, final String imagePath) {
        return UserInfoDto.builder()
                .userCid(userEntity.getUserCid())
                .userId(userEntity.getUserId())
                .userName(userEntity.getUsername())
                .profileImgPath(imagePath)
                .build();
    }
}
