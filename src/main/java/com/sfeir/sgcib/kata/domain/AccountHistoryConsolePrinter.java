package com.sfeir.sgcib.kata.domain;

import java.io.Serializable;

import com.sfeir.sgcib.kata.util.AppConstants;


public class AccountHistoryConsolePrinter implements AccountHistoryPrinter, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String printAccountHistory(Account account) {
		StringBuilder statementSB = new StringBuilder();
		statementSB.append(AppConstants.ACCOUNT_STATEMENT_HEADER)
				   .append(System.lineSeparator());
		
		account.getOperations().forEach(operation->{
			statementSB.append(operation.getReference())
			           .append(AppConstants.ACCOUNT_STATEMENT_SEPARATOR)
			           .append(operation.getDateTime())
			           .append(AppConstants.ACCOUNT_STATEMENT_SEPARATOR)
			           .append((operation.isCreditOperation() ? "":"-") + operation.getAmount())
			           .append(AppConstants.ACCOUNT_STATEMENT_SEPARATOR)
			           .append(operation.getAccount().getBalanceAtOperation(operation))
			           .append(System.lineSeparator());
		});
		
		System.out.print(statementSB);
		
		return statementSB.toString();
	}

}
