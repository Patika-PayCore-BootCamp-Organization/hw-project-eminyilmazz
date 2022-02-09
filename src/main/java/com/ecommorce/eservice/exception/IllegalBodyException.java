package com.ecommorce.eservice.exception;

public class IllegalBodyException extends IllegalArgumentException{
    private static final String generic = "IllegalBodyException:\nCheck validity of your body for -> ";
    public IllegalBodyException(String s) {
        super(generic + s);
    }
}
