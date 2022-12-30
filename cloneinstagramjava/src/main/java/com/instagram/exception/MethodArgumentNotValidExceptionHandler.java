package com.instagram.exception;

import com.instagram.dto.InsResponseCode;
import com.instagram.dto.InsResponseEntity;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ResponseEntity<Object> processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        InsErrorMessage error = null;
        for (org.springframework.validation.FieldError fieldError : fieldErrors) {
            error = new InsErrorMessage(new Date(), fieldError.getDefaultMessage(), fieldError.getField());
        }
        return InsResponseEntity.response(InsResponseCode.BAD_REQUEST.getCode(), InsResponseCode.BAD_REQUEST.getMessage(), HttpStatus.BAD_REQUEST, error);
    }


}