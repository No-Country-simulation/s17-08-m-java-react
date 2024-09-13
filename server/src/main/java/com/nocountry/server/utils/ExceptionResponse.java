package com.nocountry.server.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Component
public class ExceptionResponse {

    public static Object create(Throwable exception, HttpServletRequest request, String message) {
        return ApiError.builder()
                .message(message)
                .backMessage(exception.getLocalizedMessage())
                .method(request.getMethod())
                .url(request.getRequestURL().toString())
                .timeStamp(java.time.LocalDateTime.now())
                .build();
    }

    public static Object create(Throwable exception, HttpServletRequest request) {
        return ApiError.builder()
                .message(exception.getMessage())
                .backMessage(exception.getLocalizedMessage())
                .method(request.getMethod())
                .url(request.getRequestURL().toString())
                .timeStamp(java.time.LocalDateTime.now())
                .build();
    }

    public static Object create(MethodArgumentNotValidException exception, HttpServletRequest request) {
        return ApiError.builder()
                .message(exception.getAllErrors().stream().map(each -> each.getDefaultMessage()).toList().toString())
                .method(request.getMethod())
                .url(request.getRequestURL().toString())
                .timeStamp(java.time.LocalDateTime.now())
                .build();
    }
}
