package com.capgemini.pecunia.passbookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.pecunia.passbookservice.dto.CustomError;


@RestControllerAdvice
public class PassBookServiceExceptionAdvice {
	
	@ExceptionHandler(NoTransactionsException.class)
	public ResponseEntity<CustomError> mapException(NoTransactionsException ex)
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
	
	@ExceptionHandler(ToDateException.class)
	public ResponseEntity<CustomError> mapToDateException(ToDateException ex)
	{
		CustomError error=new CustomError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(ToDateAfterCurrentDateException.class)
	public ResponseEntity<CustomError> mapToDateCurrentException(ToDateAfterCurrentDateException ex)
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
