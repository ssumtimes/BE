package org.sometimes.sometimes.global.web.advice.exception.jwt;

public class CustomJwtBadReqException extends RuntimeException {

    public CustomJwtBadReqException(String message) {
        super(message);
    }
}
