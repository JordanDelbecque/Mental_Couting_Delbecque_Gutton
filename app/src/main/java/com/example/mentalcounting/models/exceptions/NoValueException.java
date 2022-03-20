package com.example.mentalcounting.models.exceptions;

public class NoValueException extends Exception {
    public NoValueException(String message){
        super(message);
    }
    public NoValueException(String message, Throwable innerException){
        super(message, innerException);
    }
}

