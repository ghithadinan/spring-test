package com.geekseat.sorcerer.saga.exception;

public class UnprocessableEntityException extends BaseException {

    public UnprocessableEntityException() {
        this.setMessage("Unprocessable Entity");
    }

    public UnprocessableEntityException(String message) {
        this.setMessage(message);
    }
}
