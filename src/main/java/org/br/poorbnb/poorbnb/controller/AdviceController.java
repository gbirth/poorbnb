package org.br.poorbnb.poorbnb.controller;

import org.br.poorbnb.poorbnb.exception.HotelException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HotelException exception(Exception e) {
        HotelException he = HotelException.builder()
                .cause(e.getCause().toString())
                .message(e.getMessage())
                .stackTrace(e.getStackTrace().toString())
                .build();

        return he;
    }
}
