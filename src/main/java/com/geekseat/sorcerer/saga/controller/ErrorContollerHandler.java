package com.geekseat.sorcerer.saga.controller;

import com.geekseat.sorcerer.saga.exception.BaseException;
import com.geekseat.sorcerer.saga.helpers.Response;
import com.geekseat.sorcerer.saga.model.ResponseErrorModel;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorContollerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(Exception ex) {
        Map<String, Object> response = Response.baseResponseMap("Internal Server Error");
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof BaseException baseEx) {
            status = baseEx.getHttpStatus();
            if (status != HttpStatus.NOT_IMPLEMENTED) {
                response = Response.baseResponseMap(baseEx.getMessage());
            } else {
                response = Response.baseResponseMap("Not Implemented");
            }
        } else if (ex != null) {
            return new ResponseEntity<>(response, status);
        }

        return new ResponseEntity<>(response, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ObjectError> objectErrors = ((BeanPropertyBindingResult) ex.getBindingResult()).getAllErrors();
        List<ResponseErrorModel> listErr = new ArrayList<>();
        if (!objectErrors.isEmpty()) {
            for (ObjectError obje : objectErrors) {
                FieldError fieldError = (FieldError) obje;
                listErr.add(new ResponseErrorModel(fieldError.getField(), obje.getDefaultMessage()));
            }
            return Response.badRequest(listErr);

        }
        return Response.badRequest(ex.getMessage());
    }
}
