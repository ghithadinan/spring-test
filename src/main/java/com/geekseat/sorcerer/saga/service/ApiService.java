package com.geekseat.sorcerer.saga.service;

import com.geekseat.sorcerer.saga.helpers.Response;
import com.geekseat.sorcerer.saga.model.Calculate;
import com.geekseat.sorcerer.saga.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {
    public ResponseEntity<Object> calculate(List<Person> req) {
        Calculate calculate = new Calculate(req);
        calculate.setPersons(req);
        return Response.success(calculate);
    }
}
