package com.capgemini.pecunia.atmservice.exception;


public class AtmCardNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4227171665478076830L;


	public AtmCardNotFoundException(String message) {
		super(message);
	}
	

}
