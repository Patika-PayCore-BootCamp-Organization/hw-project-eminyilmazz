package com.ecommorce.eservice.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("NotFoundException: \n " + message);
    }
}