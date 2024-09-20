package org.sometimes.sometimes.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.global.repository.ImageRepository;
import org.sometimes.sometimes.global.web.advice.exception.CustomNotFoundException;
import org.sometimes.sometimes.global.web.entity.ImageEntity;
import org.sometimes.sometimes.user.util.UserValidation;
import org.sometimes.sometimes.user.web.dto.getUser.UserInfoDto;
import org.sometimes.sometimes.user.web.entity.UserEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    // REPOSITORY
    private final ImageRepository imageRepository;

    // UTIL
    private final UserValidation userValidation;

    /**
     * 유저의 정보를 불러옵니다.
     *
     * @param user 현재 로그인한 사용자 엔티티
     * @return UserInfoDto 유저의 정보를 담은 dto
     */
    public UserInfoDto getUserInfo(User user) {
        UserEntity userEntity = userValidation.validateExistUser(user.getUsername());

        String imagePath = null;

        if(userEntity.getUserProfileImageCid() != null) {
            ImageEntity profileImage = imageRepository.findById(userEntity.getUserProfileImageCid())
                    .orElseThrow(() -> new CustomNotFoundException("일치하는 이미지가 없습니다."));

            imagePath = profileImage.getPath();
        }

        return UserInfoDto.from(userEntity,imagePath);
    }
}
