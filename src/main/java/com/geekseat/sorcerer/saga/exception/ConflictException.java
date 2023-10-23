package com.geekseat.sorcerer.saga.exception;

public class ConflictException extends BaseException {

    public ConflictException() {
        this.setMessage("Conflict");
    }

    public ConflictException(String message) {
        this.setMessage(message);
    }
}
