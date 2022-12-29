package com.instagram.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class InsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentException(
            Exception ex) {
        String exceptionMessageDesc = ex.getLocalizedMessage();
        if (exceptionMessageDesc == null) exceptionMessageDesc = ex.toString();

        InsErrorMessage errorMessage = new InsErrorMessage(new Date(), exceptionMessageDesc, null);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> generalException(
            Exception ex) {
        String exceptionMessageDesc = ex.getLocalizedMessage();
        if (exceptionMessageDesc == null) exceptionMessageDesc = ex.toString();

        InsErrorMessage errorMessage = new InsErrorMessage(new Date(), exceptionMessageDesc, null);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
