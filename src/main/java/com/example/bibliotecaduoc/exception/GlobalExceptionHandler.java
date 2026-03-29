package com.example.bibliotecaduoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {//no está implementado (falta jpa)

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleRuntimeException(RuntimeException ex) {
        return new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage()
        );
    }
}
