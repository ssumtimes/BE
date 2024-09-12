package org.sometimes.sometimes.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.user.repository.UserRepository;
import org.sometimes.sometimes.user.util.UserValidation;
import org.sometimes.sometimes.user.web.dto.auth.SignupReqDto;
import org.sometimes.sometimes.user.web.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    // REPOSITORY
    private final UserRepository userRepository;

    // UTIL
    private final PasswordEncoder passwordEncoder;
    private final UserValidation userValidation;

    /**
     * 회원가입
     * @param signupReqDto 가입을 진행하는 유저의 정보
     */
    public void signup(SignupReqDto signupReqDto) {
        idDuplicateTest(signupReqDto.getUserId());

        String hashedPwd = passwordEncoder.encode(signupReqDto.getUserPwd());

        UserEntity signupUser = UserEntity.from(signupReqDto, hashedPwd);

        userRepository.save(signupUser);
    }



    // 함수------------------------------------------------

    /**
     * 기능 - 이메일 중복 테스트
     * @param userId
     */
    public void idDuplicateTest(String userId) {
        userValidation.validateDuplicateUserId(userId);
    }
}
