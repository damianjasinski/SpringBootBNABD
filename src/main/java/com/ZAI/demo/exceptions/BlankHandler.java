package com.ZAI.demo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice

public class BlankHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, String>> validateBody(MethodArgumentNotValidException exp) {
        log.info(exp.getBindingResult().toString());
        Map<String, String> errors = new HashMap<>();
        exp.getBindingResult().getAllErrors().forEach(
                (error) ->
                    errors.put( ((FieldError) error).getField(), error.getDefaultMessage())
                );
        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }

}
