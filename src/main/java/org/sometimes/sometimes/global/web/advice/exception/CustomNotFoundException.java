package org.sometimes.sometimes.global.web.advice.exception;

public class CustomNotFoundException extends RuntimeException{

    CustomNotFoundException(){

    }

    public CustomNotFoundException(String message) {
        super(message);
    }

}
