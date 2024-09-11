package org.sometimes.sometimes.global.web.advice;

import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.global.web.advice.exception.*;
import org.sometimes.sometimes.global.web.dto.CommonResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<CommonResponseDto> handleNotFoundException(CustomNotFoundException e){
        log.error("[NOTFOUND] DB에 일치하는 결과가 없어 다음의 에러메시지를 출력합니다." + e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                CommonResponseDto.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message(e.getMessage())
                        .success(false)
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CustomDataIntegrityViolationException.class)
    public ResponseEntity<CommonResponseDto> handleDataIntegrityViolationException(CustomDataIntegrityViolationException e) {
        log.error("[CONFLICT] 데이터 무결성 에러로 다음의 에러메시지를 출력합니다." + e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                CommonResponseDto.builder()
                        .code(HttpStatus.CONFLICT.value())
                        .message(e.getMessage())
                        .success(false)
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomNoSuchElementException.class)
    public ResponseEntity<CommonResponseDto> handleNoSuchElementException(CustomNoSuchElementException e) {
        log.error("[NO_CONTENT] 데이터 무결성 에러로 다음의 에러메시지를 출력합니다." + e.getMessage());
        CommonResponseDto responseDto = CommonResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .success(false)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CustomAccessDeniedException.class)
    public ResponseEntity<CommonResponseDto> handleAccessDeniedException(CustomAccessDeniedException e) {
        log.error("[CONFLICT] 인증 에러로 다음의 에러메시지를 출력합니다." + e.getMessage());
        CommonResponseDto responseDto = CommonResponseDto.builder()
                .code(HttpStatus.CONFLICT.value())
                .message(e.getMessage())
                .success(false)
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDto);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomMissingFileException.class)
    public ResponseEntity<CommonResponseDto> handleMissingFileException(CustomMissingFileException e) {
        log.error("[BAD REQUEST] 파일이 누락되었습니다: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                CommonResponseDto.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(e.getMessage())
                        .success(false)
                        .build()
        );
    }
}
