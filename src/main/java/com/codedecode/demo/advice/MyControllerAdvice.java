package com.codedecode.demo.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codedecode.demo.custom.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		
		return new ResponseEntity<String>("Input field is Empty, Please look into it", HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException){
		
		return new ResponseEntity<String>("No value is present in DB , Please change your request", HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(" Please change http method type", HttpStatus.NOT_FOUND);
	}
	
	
	

}
