package com.currencyswapp.exception;

public class UnableToGetConversionRate extends RuntimeException{
    private final String message;

    public UnableToGetConversionRate(String message) { this.message = message; }

    @Override
    public String getMessage() { return this.message; }
}
