package com.currencyswapp.exception;

public class InvalidAmountException extends RuntimeException{
    public String message;
    public InvalidAmountException (String message){ this.message = message; }

    @Override
    public String getMessage() { return this.message; }
}
