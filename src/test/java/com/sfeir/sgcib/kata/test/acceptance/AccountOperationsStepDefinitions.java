package com.sfeir.sgcib.kata.test.acceptance;

import static org.junit.Assert.fail;

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

	@Before
	public void setUp() {

	}

	@Given("I deposit {int} euros")
	public void iDeposit(Integer amount) {
		fail("Not implemented");
	}

	@Given("I withdraw {int} euros")
	public void iWithdraw(Integer amount) {
		fail("Not implemented");
	}

	@When("I ask the account statement")
	public void iAskTheAccountStatement() {
		fail("Not implemented");
	}

	@Then("My account's balance should be {int} euros")
	public void myAccountBalanceShouldBe(Integer balance) {
		fail("Not implemented");
	}

}
