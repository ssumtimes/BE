package org.sometimes.sometimes.global.web.advice.exception;

public class CustomAccessDeniedException extends RuntimeException{

    public CustomAccessDeniedException(String message){
        super(message);
    }
}
