package com.capgemini.pecunia.passbookservice.exception;

public class ToDateAfterCurrentDateException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ToDateAfterCurrentDateException(String message) {
		super(message);
	}
	

}
