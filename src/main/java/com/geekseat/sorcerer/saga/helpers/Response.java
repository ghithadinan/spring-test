package com.geekseat.sorcerer.saga.helpers;

import com.geekseat.sorcerer.saga.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Response {

    public static Map<String, Object> baseResponseMap(String message, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("data", data);
        return result;
    }

    public static Map<String, Object> baseResponseMap(String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("data", null);
        return result;
    }

    public static ResponseEntity<Object> success() {
        ResponseModel res = new ResponseModel();
        res.setMesage("Success");
        return ResponseEntity.ok().body(res);
    }

    public static ResponseEntity<Object> success(Object data) {
        ResponseModel res = new ResponseModel();
        res.setMesage("Success");
        res.setData(data);
        return ResponseEntity.ok().body(res);
    }

    public static ResponseEntity<Object> created(Object data) {
        return new ResponseEntity<>(baseResponseMap("Created", data), HttpStatus.CREATED);
    }

    public static ResponseEntity<Object> unprocessableEnity(String message) {
        ResponseModel res = new ResponseModel();
        res.setMesage(message);
        return ResponseEntity.unprocessableEntity().body(res);
    }

    public static ResponseEntity<Object> badRequest() {
        ResponseModel res = new ResponseModel();
        res.setMesage("Bad Request");
        return ResponseEntity.badRequest().body(res);
    }

    public static ResponseEntity<Object> badRequest(Object data) {
        ResponseModel res = new ResponseModel();
        res.setMesage("Bad Request");
        res.setData(data);
        return ResponseEntity.badRequest().body(res);
    }

    public static ResponseEntity<Object> badRequest(String message) {
        ResponseModel res = new ResponseModel();
        res.setMesage(message);
        return ResponseEntity.badRequest().body(res);
    }

    public static ResponseEntity<Object> badRequest(String message, Object data) {
        ResponseModel res = new ResponseModel();
        res.setMesage(message);
        res.setData(data);
        return ResponseEntity.badRequest().body(res);
    }

    public static ResponseEntity<Object> notFound(String message) {
        return new ResponseEntity<>(baseResponseMap(message), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<Object> notFound() {
        return new ResponseEntity<>(baseResponseMap("Not found"), HttpStatus.NOT_FOUND);
    }
}
