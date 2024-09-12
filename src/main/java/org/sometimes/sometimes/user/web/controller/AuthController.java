package org.sometimes.sometimes.user.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.global.web.dto.CommonResponseDto;
import org.sometimes.sometimes.user.service.AuthService;
import org.sometimes.sometimes.user.web.dto.auth.SignupReqDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/public/auth")
@RequiredArgsConstructor
@Tag(name = "[PUBLIC] 회원관련 API")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "회원가입", description = "회원가입을 다루는 API입니다.")
    @PostMapping("/signup")
    public ResponseEntity<CommonResponseDto> signup(@RequestBody SignupReqDto signupReqDto) {
        log.debug("[AUTH] 회원가입 요청이 들어왔습니다. \n{}", signupReqDto);
        authService.signup(signupReqDto);
        log.debug("[AUTH] 회원가입 성공");

        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponseDto.createSuccessResponse("회원가입 성공"));
    }
}
