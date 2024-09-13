package com.nocountry.server.exception;

public class RoleInvalidException extends RuntimeException{
    public RoleInvalidException(String message) {
        super(message);
    }
}
