package org.br.poorbnb.poorbnb.controller;

import org.br.poorbnb.poorbnb.exception.HotelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<HotelException> exception(Exception e) {
        HotelException he = HotelException.builder()
                .causedFor(e.getCause().toString())
                .message(e.getMessage())
                .stTrace(e.getStackTrace().toString())
                .build();

        return new ResponseEntity<>(he, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
