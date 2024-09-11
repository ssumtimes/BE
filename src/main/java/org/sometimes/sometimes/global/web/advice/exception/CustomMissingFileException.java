package org.sometimes.sometimes.global.web.advice.exception;

public class CustomMissingFileException extends RuntimeException{

    public CustomMissingFileException(String message){
        super(message);
    }
}