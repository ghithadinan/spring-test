package com.geekseat.sorcerer.saga.exception;

public class NotFoundException extends BaseException {

    public NotFoundException() {
        this.setMessage("Not Found");
    }

    public NotFoundException(String message) {
        this.setMessage(message);
    }
}
