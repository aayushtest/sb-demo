package com.aayush.sb.demo.exceptions;

public class InvalidIdException extends RuntimeException {

    public InvalidIdException(String message){
        super(message);
    }

    public String IdDoesNotExist(String message){
        return message;
    }
}
