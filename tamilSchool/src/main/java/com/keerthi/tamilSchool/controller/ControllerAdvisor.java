package com.keerthi.tamilSchool.controller;

import com.keerthi.tamilSchool.exception.EmployeeNotFoundException;
import com.keerthi.tamilSchool.exception.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler
    public ResponseEntity<String> handException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<Error> handException(EmployeeNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error(exception.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
}
