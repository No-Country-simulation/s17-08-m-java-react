package com.nocountry.server.config.advice;

import com.nocountry.server.utils.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MailSendException.class)
    public ResponseEntity<Object> mailSendException(MailSendException exception, HttpServletRequest request) {
        return ResponseEntity.status(500).body(ExceptionResponse.create(exception, request, "Failed to connect to the mail server."));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> badCredentialsException(BadCredentialsException exception, HttpServletRequest request) {
        return ResponseEntity.status(401).body(ExceptionResponse.create(exception, request, "username or password is incorrect."));
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<Object> lockedException(LockedException exception, HttpServletRequest request) {
        return ResponseEntity.status(401).body(ExceptionResponse.create(exception, request, "Your account is locked."));
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<Object> disabledException(DisabledException exception, HttpServletRequest request) {
        return ResponseEntity.status(401).body(ExceptionResponse.create(exception, request, "Your account is disabled."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception exception, HttpServletRequest request) {
        return ResponseEntity.status(500).body(ExceptionResponse.create(exception, request, "An unexpected error has occurred. We are working to resolve the problem."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        return ResponseEntity.status(400).body(ExceptionResponse.create(exception, request));
    }
}
