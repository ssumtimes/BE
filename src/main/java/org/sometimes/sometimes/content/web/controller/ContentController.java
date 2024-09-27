package org.sometimes.sometimes.content.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.content.service.ContentService;
import org.sometimes.sometimes.global.web.dto.CommonResponseDto;
import org.sometimes.sometimes.user.web.dto.auth.SignupReqDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/admin/auth")
@RequiredArgsConstructor
@Tag(name = "[ADMIN] 컨텐츠 등록 API")
public class ContentController {

    //SERVICE
    private final ContentService contentService;

    @Operation(summary = "컨텐츠 등록", description = "컨텐츠 사진 등록 API 입니다.")
    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDto> signup(
            @RequestPart(name = "contentImage") MultipartFile contentImage
    ) {
        contentService.addPhoto(contentImage);

        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponseDto.createSuccessResponse("회원가입 성공"));
    }
}
