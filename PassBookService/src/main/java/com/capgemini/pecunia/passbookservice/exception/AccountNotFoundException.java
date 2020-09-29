package com.capgemini.pecunia.passbookservice.exception;

public class AccountNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 4227171665478076830L;

	public AccountNotFoundException(String message) {
		super(message);
	}
	
	

}
