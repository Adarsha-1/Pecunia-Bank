package com.capgemini.pecunia.accountservice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.capgemini.pecunia.accountservice.exceptions.AadharNotFoundException;
import com.capgemini.pecunia.accountservice.exceptions.AccountNoNotFoundException;
import com.capgemini.pecunia.accountservice.exceptions.ExceptionResponse;



@ControllerAdvice
public class AccountControllerAdvice {
	  @ExceptionHandler(Exception.class)
	  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
	@ExceptionHandler(AccountNoNotFoundException.class)
    public final ResponseEntity<String> exceptionHandler
                        ( AccountNoNotFoundException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(AadharNotFoundException.class)
    public final ResponseEntity<String> exceptionHandler
                        ( AadharNotFoundException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	      ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
	        ex.getBindingResult().toString());
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	  } 
	
}