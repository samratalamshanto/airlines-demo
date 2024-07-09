package com.samarat.airlinesdemoproject.config.exception;

import com.samarat.airlinesdemoproject.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DateValidationException.class)
    public ResponseEntity<CommonResponse> dateValidationException(DateValidationException ex) {
        printException(ex);
        CommonResponse commonResponse = new CommonResponse(400, false, ex.getMessage(), null);
        return new ResponseEntity<>(commonResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DateParseException.class)
    public ResponseEntity<CommonResponse> dateParseException(DateParseException ex) {
        printException(ex);
        CommonResponse commonResponse = new CommonResponse(400, false, ex.getMessage(), null);
        return new ResponseEntity<>(commonResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CommonResponse> commonException(Exception ex) {
        printException(ex);
        CommonResponse commonResponse = new CommonResponse(500, false, "Something went wrong. Please try again later.", null);
        return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void printException(Exception ex) {
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        printWriter.flush();
        String stackTrace = writer.toString();
        log.error(stackTrace);
    }
}
