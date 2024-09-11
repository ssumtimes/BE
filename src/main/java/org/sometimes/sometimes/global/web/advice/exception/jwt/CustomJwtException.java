package org.sometimes.sometimes.global.web.advice.exception.jwt;

public class CustomJwtException extends RuntimeException{

    public CustomJwtException(String message) {
        super(message);}
}
