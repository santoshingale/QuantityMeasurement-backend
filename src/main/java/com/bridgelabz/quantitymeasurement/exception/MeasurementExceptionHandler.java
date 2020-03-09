package com.bridgelabz.quantitymeasurement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MeasurementExceptionHandler {
    @ExceptionHandler(MeasurementException.class)
    public ResponseEntity measurementExHandkler(MeasurementException e){
        return new ResponseEntity(e.message, HttpStatus.BAD_REQUEST);
    }
}
