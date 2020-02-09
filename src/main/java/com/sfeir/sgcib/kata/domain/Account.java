package com.sfeir.sgcib.kata.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfeir.sgcib.kata.exception.DebitNotAllowedException;

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

	private List<Operation> operations = new ArrayList<>();
	
	private AccountHistoryPrinter statementPrinter = new AccountHistoryConsolePrinter();
	
	private final Logger LOG = LoggerFactory.getLogger(Account.class);

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
		Double balance = operations.stream().mapToDouble(operation -> {
			return operation.getAmount() * (operation.isCreditOperation() ? 1 : -1);
		}).sum();
		
		LOG.info("Requested balance is: {}",balance);
		return balance;
	}

	/**
	 * @param operation
	 * @return
	 */
	public Double getBalanceAtOperation(Operation operation) {
		return operations.stream().filter(op -> {
			return op.getReference() <= operation.getReference();
		}).mapToDouble(op -> {
			return op.getAmount() * (op.isCreditOperation() ? 1 : -1);
		}).sum();
	}

	/**
	 * @return the account's deposit and withdrawal operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}


	/**
	 * @param amount
	 * @return the persisted deposit operation object
	 */
	public Operation executeDepositOperation(Double amount) {
		Operation operation = new Operation.OperationBuilder().withAmount(amount).withAmount(amount)
				.withDateTime(new Date(System.currentTimeMillis())).withType(OperationType.DEPOSIT).withAccount(this).build();
		operation.execute();

		getOperations().add(operation);

		return operation;
	}

	/**
	 * @param amount
	 * @return the persisted withdrawal operation object This method will create and
	 *         execute (save) a withdrawal operation
	 * @throws DebitNotAllowedException 
	 */
	public Operation executeWithdrawalOperation(Double amount) throws DebitNotAllowedException {
		if(getBalance()<amount) {
			throw new DebitNotAllowedException();
		}
		
		Operation operation = new Operation.OperationBuilder().withAmount(amount).withAmount(amount)
				.withDateTime(new Date(System.currentTimeMillis())).withType(OperationType.WITHDRAWAL).withAccount(this).build();
		operation.execute();

		getOperations().add(operation);

		return operation;
	}
	
	public String printAccountStatement() {
		return statementPrinter.printAccountHistory(this);
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
