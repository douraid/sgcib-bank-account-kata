package com.sfeir.sgcib.kata.domain;

import java.io.Serializable;
import java.util.List;

import javax.naming.OperationNotSupportedException;


/**
 * 
 * @author Douraid
 *
 */
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long accountNumber;

	private Client client;

	private List<Operation> operations;

	private Double balance;

	/**
	 * @return
	 */
	public Long getAccountNumber() {
		return accountNumber;
	}


	public Client getClient() {
		return client;
	}

	/**
	 * @return
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param operation
	 * @return
	 * @throws OperationNotSupportedException 
	 */
	public Double getBalanceAtOperation(Operation operation) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("Not implemented");
	}

	
	/**
	 * @return the account's deposit and withdrawal operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}


	/**
	 * @return the created account object
	 * @throws OperationNotSupportedException 
	 */
	public Account createAccount() throws OperationNotSupportedException {
		throw new OperationNotSupportedException("Not implemented");
	}

	/**
	 * @param amount
	 * @return the persisted deposit operation object
	 * @throws OperationNotSupportedException 
	 */
	public Operation executeDepositOperation(Double amount) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("Not implemented");
	}

	/**
	 * @param amount
	 * @return the persisted withdrawal operation object
	 * This method will create and execute (save) a withdrawal operation
	 * @throws OperationNotSupportedException 
	 */
	public Operation executeWithdrawalOperation(Double amount) throws OperationNotSupportedException {
		throw new OperationNotSupportedException("Not implemented");
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}
	
	

}
