package com.shop.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> adminExceptionHandler(AdminException ex , WebRequest wb){
		ErrorDetails ed = new ErrorDetails(ex.getMessage(), wb.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception ex , WebRequest wb){
		ErrorDetails ed = new ErrorDetails(ex.getMessage(), wb.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
	
}
