package org.sometimes.sometimes.user.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.global.web.dto.CommonResponseDto;
import org.sometimes.sometimes.user.service.AuthService;
import org.sometimes.sometimes.user.web.dto.auth.LoginReqDto;
import org.sometimes.sometimes.user.web.dto.auth.SignupReqDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/public/auth")
@RequiredArgsConstructor
@Tag(name = "[PUBLIC] 회원관련 API")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "회원가입", description = "회원가입을 다루는 API 입니다.")
    @PostMapping("/signup")
    public ResponseEntity<CommonResponseDto> signup(@RequestBody SignupReqDto signupReqDto) {
        log.debug("[AUTH] 회원가입 요청이 들어왔습니다. \n{}", signupReqDto);
        authService.signup(signupReqDto);
        log.debug("[AUTH] 회원가입 성공");

        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponseDto.createSuccessResponse("회원가입 성공"));
    }

    @Operation(summary = "로그인", description = "로그인을 다루는 API 입니다.")
    @PostMapping("/login")
    public ResponseEntity<CommonResponseDto> login(@RequestBody LoginReqDto loginInfo, HttpServletResponse httpServletResponse) {
        log.debug("[AUTH] 로그인 요청이 들어왔습니다. \n{}", loginInfo);
        authService.login(loginInfo, httpServletResponse);
        log.debug("[AUTH] 로그인이 성공적으로 이루어 졌습니다.");

        return ResponseEntity.ok(CommonResponseDto.successResponse("로그인 성공"));
    }

    @Operation(summary = "아이디 중복 테스트", description = "아이디가 중복되었는지 확인하는 API 입니다.")
    @GetMapping("/duplicate-test/user-id")
    public ResponseEntity<CommonResponseDto> emailDuplicateTest(@RequestParam String userId) {
        log.debug("[DUPLICATE] 이메일 중복확인 요청이 들어왔습니다.");
        authService.idDuplicateTest(userId);
        log.debug("[DUPLICATE] 이메일 중복검사가 정상적으로 이루어 졌습니다.");
        return ResponseEntity.ok().body(CommonResponseDto.successResponse("사용가능한 이메일입니다."));
    }
}
