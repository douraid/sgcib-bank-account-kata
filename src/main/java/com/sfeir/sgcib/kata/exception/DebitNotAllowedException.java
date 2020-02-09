package com.sfeir.sgcib.kata.exception;
/**
 * 
 * @author Douraid
 *
 */
public class DebitNotAllowedException extends AbstractBusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DebitNotAllowedException() {
		super("Your account balance is not sufficient");
	}

}
