package com.ecommorce.eservice.exception;

public class IllegalAuthenticationException extends IllegalArgumentException{
    public IllegalAuthenticationException(String m) {
        super("IllegalAuthenticationException: \n" + m);
    }
}
