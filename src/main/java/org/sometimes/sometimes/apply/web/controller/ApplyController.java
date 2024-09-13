package org.sometimes.sometimes.apply.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.apply.service.ApplyService;
import org.sometimes.sometimes.apply.web.dto.req.ApplyReqDto;
import org.sometimes.sometimes.global.web.dto.CommonResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user/apply")
@RequiredArgsConstructor
@Tag(name = "[USER] 회원관련 API")
public class ApplyController {

    // SERVICE
    private final ApplyService applyService;

    /*
     * 신청서 작성
     */
    @Operation(summary = "신청서 작성", description = "신청서 작성 요청 API 입니다.")
    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDto> createApply(
            @AuthenticationPrincipal User user,
            @RequestPart(name = "applyReqDto") @Parameter(schema = @Schema(type = "string", format = "binary")) ApplyReqDto applyReqDto,
            @RequestPart(name = "facePhotos") List<MultipartFile> facePhotos,
            @RequestPart(name = "bodyPhoto") MultipartFile bodyPhoto
            ) {
        log.debug("[APPLY] 신청서 작성 요청이 들어왔습니다. {}", applyReqDto);
        applyService.createApply(user, applyReqDto, facePhotos, bodyPhoto);
        log.debug(("[APPLY] 신청서 작성 성공"));

        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponseDto.createSuccessResponse("신청서 작성 성공"));
    }
    /*
      신청서 수정
     */


    /*
     * 작성한 신청서 조회
     */
}

