package com.ecommorce.eservice.exception;

public class IllegalBodyException extends IllegalArgumentException{
    static final String GENERIC = "IllegalBodyException:\nCheck validity of your body for -> ";
    public IllegalBodyException(String s) {
        super(GENERIC + s);
    }
}
