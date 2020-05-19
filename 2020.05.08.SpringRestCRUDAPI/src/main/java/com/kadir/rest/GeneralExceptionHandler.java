package com.kadir.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<GeneralErrorResponse> hataYakala(Exception exc) {
		GeneralErrorResponse hata = new GeneralErrorResponse();

		hata.setStatus(HttpStatus.BAD_REQUEST.value());
		hata.setMessage(exc.getMessage());

		return new ResponseEntity<>(hata, HttpStatus.BAD_REQUEST);
	}
}
