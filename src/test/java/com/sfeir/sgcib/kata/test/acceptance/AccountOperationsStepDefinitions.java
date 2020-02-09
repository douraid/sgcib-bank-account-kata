package com.sfeir.sgcib.kata.test.acceptance;

import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfeir.sgcib.kata.domain.Account;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Douraid
 *
 */
public class AccountOperationsStepDefinitions {
	
	private Account account = new Account();
	
	private String accountStatement;
	
	
	private final Logger LOG = LoggerFactory.getLogger(AccountOperationsStepDefinitions.class);


	@Before
	public void setUp() {
		
		
	}
	

	@Given("I deposit {int} euros")
	public void iDeposit(Integer amount) {
		account.executeDepositOperation(amount.doubleValue()); 
	}

	@Given("I withdraw {int} euros")
	public void iWithdraw(Integer amount) {
		try {
			account.executeWithdrawalOperation(amount.doubleValue()); 
		}
		catch(Exception e) {
			LOG.info("Withdrawal operation not permitted");
		}
	}

	@When("I ask the account statement")
	public void iAskTheAccountStatement() {
		accountStatement = account.printAccountStatement();
	}

	@Then("My account's balance should be {int} euros")
	public void myAccountBalanceShouldBe(Integer balance) {
		String[] statementLines = accountStatement.split(System.lineSeparator());
		String[] lastTransactionParts = statementLines[statementLines.length-1].split("\\|");
		Integer statementBalance = (int) Double.parseDouble(lastTransactionParts[lastTransactionParts.length-1]);
		Assertions.assertThat(statementBalance).isEqualTo(balance);
	}

}
