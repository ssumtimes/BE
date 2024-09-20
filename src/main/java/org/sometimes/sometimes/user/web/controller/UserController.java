package org.sometimes.sometimes.user.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.user.service.UserService;
import org.sometimes.sometimes.user.web.dto.getUser.GetUserInfoResDto;
import org.sometimes.sometimes.user.web.dto.getUser.UserInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "[PRIVATE] 유저관련 API")
public class UserController {

    // SERVICE
    private final UserService userService;

    @Operation(summary = "유저 정보 조회", description = "유저의 정보를 조회하는 api입니다.")
    @GetMapping("/info")
    public ResponseEntity<GetUserInfoResDto> getUserInfo(
            @AuthenticationPrincipal User user
    ) {
        log.debug("[USER] 유저 정보 조회 요청이 들어왔습니다.");
        UserInfoDto userInfo = userService.getUserInfo(user);
        log.debug("[USER] 유저 정보를 성공적으로 불러왔습니다.");

        return ResponseEntity.ok(GetUserInfoResDto.successResponse("유저 정보를 불러왔습니다.", userInfo));
    }
}
