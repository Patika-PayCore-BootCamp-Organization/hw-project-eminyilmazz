package com.ecommorce.eservice.exception;

public class IllegalAuthenticationException extends IllegalArgumentException {
    public IllegalAuthenticationException(String message) {
        super("IllegalAuthenticationException: \n" + message);
    }
}
