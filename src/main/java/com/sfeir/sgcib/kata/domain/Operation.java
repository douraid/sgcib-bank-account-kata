package com.sfeir.sgcib.kata.domain;

import java.io.Serializable;
import java.util.Date;

import javax.naming.OperationNotSupportedException;


/**
 * 
 * @author Douraid
 *
 */
/**
 * @author arfaoui.d
 *
 */
/**
 * @author arfaoui.d
 *
 */
public class Operation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long reference;
	
	private Date dateTime;
	
	private Double amount;
	
	private OperationType type;
	
	private Account account;
	

	public Operation(Long reference, Date dateTime, Double amount, OperationType type, Account account) {
		super();
		this.reference = reference;
		this.dateTime = dateTime;
		this.amount = amount;
		this.type = type;
		this.account = account;
	}

	/**
	 * @return
	 */
	public Long getReference() {
		return reference;
	}


	/**
	 * @return
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @return
	 */
	public Double getAmount() {
		return amount;
	}
	
	
	/**
	 * @return
	 */
	public OperationType getType() {
		return type;
	}
	
	
	/**
	 * @return the associated operation's account
	 * 
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * @return true if the operation type is credit (withdrawal), false otherwise
	 */
	public boolean isCreditOperation() {
		return type.equals(OperationType.DEPOSIT);
	}
	
	/**
	 * @return true if the operation type is debit (withdrawal), false otherwise
	 */
	public boolean isDebitOperation() {
		return type.equals(OperationType.WITHDRAWAL);
	}
	
	
	/**
	 * Will execute the operation (save it into the database)
	 * @throws OperationNotSupportedException 
	 */
	public void execute() throws OperationNotSupportedException {
		throw new OperationNotSupportedException("Not implemented");
	}


	/**
	 * @author Douraid
	 * Builder class for Operation
	 */
	public static class OperationBuilder {
		
		private Long reference;
		
		private Account account;
		
		private Double amount;
		
		private Date dateTime;
		
		private OperationType type;
		
		public OperationBuilder withReference(Long reference) {
			this.reference = reference;
			return this;
		}
		
		public OperationBuilder withAccount(Account account) {
			this.account = account;
			return this;
		}
		
		public OperationBuilder withAmount(Double amount) {
			this.amount = amount;
			return this;
		}
		
		public OperationBuilder withDateTime(Date dateTime) {
			this.dateTime = dateTime;
			return this;
		}
		
		public OperationBuilder withType(OperationType type) {
			this.type = type;
			return this;
		}
		
		public Operation build() {
			return new Operation(reference, dateTime, amount, type, account);
		}
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Operation other = (Operation) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	

}
