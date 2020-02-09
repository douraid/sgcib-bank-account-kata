package com.sfeir.sgcib.kata.test.unit;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfeir.sgcib.kata.domain.Account;
import com.sfeir.sgcib.kata.exception.DebitNotAllowedException;




/**
 * 
 * @author Douraid
 *
 */
public class AccountShouldTest {
	
	private Account account;
	
	private final Logger LOG = LoggerFactory.getLogger(AccountShouldTest.class);


	@Before
	public void setUp() {
		account = new Account();
	}

	@Test
	public void execute_a_deposit_operation() {
		account.executeDepositOperation(500d);
		LOG.info("Account balance is {}",account.getBalance());
		Assertions.assertThat(account.getBalance()).isEqualTo(500d);
	}

	@Test
	public void execute_withdrawal_operation() throws DebitNotAllowedException {
		account.executeDepositOperation(500d);
		account.executeWithdrawalOperation(150d);
		Assertions.assertThat(account.getBalance()).isEqualTo(350d);
	}
	

}
