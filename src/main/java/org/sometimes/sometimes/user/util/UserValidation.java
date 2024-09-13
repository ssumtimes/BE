package org.sometimes.sometimes.user.util;

import lombok.RequiredArgsConstructor;
import org.sometimes.sometimes.global.web.advice.exception.CustomAccessDeniedException;
import org.sometimes.sometimes.global.web.advice.exception.CustomDataIntegrityViolationException;
import org.sometimes.sometimes.global.web.advice.exception.CustomNotFoundException;
import org.sometimes.sometimes.global.web.enums.user.AccountStatus;
import org.sometimes.sometimes.user.repository.UserRepository;
import org.sometimes.sometimes.user.web.dto.auth.LoginReqDto;
import org.sometimes.sometimes.user.web.entity.UserEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidation {

    // REPOSITORY
    private final UserRepository userRepository;

    // UTIL
    private final PasswordEncoder passwordEncoder;

    /**
     * 아이디 중복 확인
     * @param userId 유저가 입력한 아이디
     */
    public void validateDuplicateUserId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw new CustomDataIntegrityViolationException("이미 사용중인 아이디 입니다.");
        }
    }

    /**
     * 로그인 상태 확인
     * @param loginInfo 로그인 하려는 유저 정보
     */
    public void validateLogin(LoginReqDto loginInfo) {
        UserEntity userEntity = userRepository.findByUserId(loginInfo.getUserId())
                .orElseThrow(() -> new CustomNotFoundException("일치하는 유저가 존재하지 않습니다."));

        if(userEntity.getAccountStatus() == AccountStatus.DELETED) {
            throw new CustomAccessDeniedException("탈퇴 처리된 유저입니다.");
        }

        if(!passwordEncoder.matches(loginInfo.getUserPassword(), userEntity.getUserPwd())){
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }
    }

    /**
     * 유저 유무 확인
     * @param userId 유저 아이디
     * @return userEntity 유저 엔티티
     */
    public UserEntity validateExistUser(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(()-> new CustomNotFoundException("로그인된 유저가 존재하지 않습니다."));
    }
}
