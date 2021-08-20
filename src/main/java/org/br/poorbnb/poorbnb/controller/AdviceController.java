package org.br.poorbnb.poorbnb.controller;

import java.util.Date;

import org.br.poorbnb.poorbnb.exception.ErrorDetails;
import org.br.poorbnb.poorbnb.exception.HotelException;
import org.br.poorbnb.poorbnb.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AdviceController {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<HotelException> genericExceptionHandler(Exception e) {
		HotelException he = HotelException.builder().causedFor(e.getCause().toString()).message(e.getMessage())
				.stTrace(e.getStackTrace().toString()).build();

		return new ResponseEntity<>(he, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
