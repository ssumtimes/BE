package org.sometimes.sometimes.global.web.advice.exception;

public class CustomNoSuchElementException extends RuntimeException{
    public CustomNoSuchElementException(String message){
        super(message);
    }
}
