package com.samarat.airlinesdemoproject.config.exception;

import com.samarat.airlinesdemoproject.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DateValidationException.class)
    public ResponseEntity<CommonResponse> dateValidationException(DateValidationException ex) {
        CommonResponse commonResponse = new CommonResponse(500, false, ex.getMessage(), null);
        return new ResponseEntity<>(commonResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DateParseException.class)
    public ResponseEntity<CommonResponse> dateParseException(DateParseException ex) {
        CommonResponse commonResponse = new CommonResponse(500, false, ex.getMessage(), null);
        return new ResponseEntity<>(commonResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CommonResponse> commonException(Exception ex) {
        CommonResponse commonResponse = new CommonResponse(500, false, "Something went wrong. Please try again.", null);
        return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
