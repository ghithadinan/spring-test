package com.geekseat.sorcerer.saga.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BaseException extends RuntimeException {

    private String message = "Internal Server Error";

    private Object data = null;

    private HttpStatus httpStatus = null;
}
