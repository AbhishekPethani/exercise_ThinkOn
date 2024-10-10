package com.example.demo.exception;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle MethodArgumentTypeMismatchException when the ID is not a number
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        String errorMessage = "Invalid ID type: ID should be a number";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", errorMessage));
    }

    // Handle UserAlreadyExistsException when duplicate user ID is passed
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        String errorMessage = e.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("error", errorMessage));
    }
    
}
