package com.nocountry.server.config.advice;

import com.nocountry.server.utils.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception exception, HttpServletRequest request) {
        return ResponseEntity.status(500).body(ExceptionResponse.create(exception, request, "An unexpected error has occurred. We are working to resolve the problem."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        return ResponseEntity.status(400).body(ExceptionResponse.create(exception, request));
    }


}
