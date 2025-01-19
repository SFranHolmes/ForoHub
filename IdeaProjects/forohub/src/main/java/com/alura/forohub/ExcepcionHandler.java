package com.alura.forohub;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExcepcionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException e){
        Map<String, String> errores = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()){
            errores.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
