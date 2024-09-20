package org.sometimes.sometimes.user.service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.global.aws.ImageUploadService;
import org.sometimes.sometimes.global.config.security.TokenProvider;
import org.sometimes.sometimes.user.repository.UserRepository;
import org.sometimes.sometimes.user.util.UserValidation;
import org.sometimes.sometimes.user.web.dto.auth.LoginReqDto;
import org.sometimes.sometimes.user.web.dto.auth.SignupReqDto;
import org.sometimes.sometimes.user.web.entity.UserEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    // REPOSITORY
    private final UserRepository userRepository;

    // UTIL
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final UserValidation userValidation;

    // SERVICE
    private final ImageUploadService imageUploadService;

    /**
     * 회원가입
     * @param signupReqDto 가입을 진행하는 유저의 정보
     */
    @Transactional
    public void signup(MultipartFile profileImage, SignupReqDto signupReqDto) {
        idDuplicateTest(signupReqDto.getUserId());

        String hashedPwd = passwordEncoder.encode(signupReqDto.getUserPwd());

        UserEntity signupUser = UserEntity.from(signupReqDto, hashedPwd);

        if(profileImage != null && !profileImage.isEmpty()) {
           Long profileImageCid = imageUploadService.uploadUserProfileImage(profileImage);

           signupUser.setUserProfileImageCid(profileImageCid);
        }

        userRepository.save(signupUser);
    }

    /**
     * 로그인
     * @param loginInfo 로그인을 진행하는 유저의 정보
     */
    @Transactional
    public void login(LoginReqDto loginInfo, HttpServletResponse httpServletResponse) {
        userValidation.validateLogin(loginInfo);

        createToken(loginInfo, httpServletResponse);
    }



    // 함수------------------------------------------------

    /**
     * 아이디 중복 테스트
     * @param userId 입력한 유저 아이디
     */
    public void idDuplicateTest(String userId) {
        userValidation.validateDuplicateUserId(userId);
    }

    /**
     *
     * @param loginInfo 로그인 유저 정보
     * @param httpServletResponse 반환하기 위한 ResServlet
     */
    private void createToken(LoginReqDto loginInfo, HttpServletResponse httpServletResponse) {
        UsernamePasswordAuthenticationToken authenticationToken = loginInfo.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        tokenProvider.generateTokenDto(authentication, httpServletResponse);
    }
}
