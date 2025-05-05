package com.currencyswapp.exception;

public class UnableToLoadApiKey extends RuntimeException {

    public UnableToLoadApiKey(String message, Throwable cause) {
        super(message, cause);
    }
}
