package org.sometimes.sometimes.user.util;

import lombok.RequiredArgsConstructor;
import org.sometimes.sometimes.global.web.advice.exception.CustomDataIntegrityViolationException;
import org.sometimes.sometimes.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidation {

    private final UserRepository userRepository;

    public void validateDuplicateUserId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw new CustomDataIntegrityViolationException("이미 사용중인 이메일입니다.");
        }
    }
}
