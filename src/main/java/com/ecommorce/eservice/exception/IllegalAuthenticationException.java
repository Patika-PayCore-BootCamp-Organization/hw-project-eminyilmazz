package com.ecommorce.eservice.exception;

import org.springframework.http.HttpStatus;

public class IllegalAuthenticationException extends RuntimeException {
    public IllegalAuthenticationException(String message, HttpStatus httpStatus) {
        super("Status: " + httpStatus + "\n" + "IllegalAuthenticationException: \n" + message);
    }
}
