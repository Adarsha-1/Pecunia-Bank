package com.capgemini.pecunia.passbookservice.exception;

public class AccountNoLengthException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AccountNoLengthException(String message) {
		super(message);
	}
	

}
