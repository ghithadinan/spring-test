package com.geekseat.sorcerer.saga.controller;

import com.geekseat.sorcerer.saga.model.Person;
import com.geekseat.sorcerer.saga.service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class ApiController {
    final ApiService service;

    public ApiController(ApiService service) {
        this.service = service;
    }

    @PostMapping("calculate")
    public ResponseEntity<Object> save(@RequestBody List<Person> req) {
        return service.calculate(req);
    }
}
