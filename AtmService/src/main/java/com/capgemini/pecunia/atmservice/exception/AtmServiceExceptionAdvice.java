package com.capgemini.pecunia.atmservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.pecunia.atmservice.dto.CustomError;

@RestControllerAdvice
public class AtmServiceExceptionAdvice {
	
	@ExceptionHandler(AtmCardNotFoundException.class)
	public ResponseEntity<CustomError> mapException(AtmCardNotFoundException ex)
	{
		CustomError error=new CustomError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<CustomError> mapAccountException(AccountNotFoundException ex)
	{
		CustomError error=new CustomError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(CardAlreadyExistsException.class)
	public ResponseEntity<CustomError> mapCardException(CardAlreadyExistsException ex)
	{
		CustomError error=new CustomError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(AccountIdException.class)
	public ResponseEntity<CustomError> mapAccountIdException(AccountIdException ex)
	{
		CustomError error=new CustomError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(AccountNoLengthException.class)
	public ResponseEntity<CustomError> mapAccountNoLengthException(AccountNoLengthException ex)
	{
		CustomError error=new CustomError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
