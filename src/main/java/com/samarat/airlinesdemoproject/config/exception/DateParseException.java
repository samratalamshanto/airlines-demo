package com.samarat.airlinesdemoproject.config.exception;

public class DateParseException extends RuntimeException {
    public DateParseException() {
    }

    public DateParseException(String message) {
        super(message);
    }
}
