package org.sometimes.sometimes.global.web.advice.exception.jwt;

public class CustomExpiredJwtException extends RuntimeException {

    public CustomExpiredJwtException(String message) {
        super(message);
    }
}
