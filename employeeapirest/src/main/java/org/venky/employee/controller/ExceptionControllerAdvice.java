package org.venky.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.venky.employee.exception.EmployeeException;
import org.venky.employee.exception.ErrorResponse;
 
@ControllerAdvice
public class ExceptionControllerAdvice {
 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> generalException(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorResponse> customException(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
