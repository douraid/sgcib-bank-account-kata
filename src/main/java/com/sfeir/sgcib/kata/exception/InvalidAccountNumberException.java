package com.sfeir.sgcib.kata.exception;

public class InvalidAccountNumberException extends AbstractBusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidAccountNumberException(Long accountNumber) {
		super("Invalid account number " + accountNumber);
	}

}
