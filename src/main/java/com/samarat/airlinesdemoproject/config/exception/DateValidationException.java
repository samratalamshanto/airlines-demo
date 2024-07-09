package com.samarat.airlinesdemoproject.config.exception;

public class DateValidationException extends RuntimeException {
    public DateValidationException() {
    }

    public DateValidationException(String message) {
        super(message);
    }
}
