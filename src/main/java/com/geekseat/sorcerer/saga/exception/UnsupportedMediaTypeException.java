package com.geekseat.sorcerer.saga.exception;

public class UnsupportedMediaTypeException extends BaseException {

    public UnsupportedMediaTypeException() {
        this.setMessage("Unsuported Media Type");
    }

    public UnsupportedMediaTypeException(String message) {
        this.setMessage(message);
    }
}
