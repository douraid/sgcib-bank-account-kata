package com.sfeir.sgcib.kata.test.unit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.sfeir.sgcib.kata.domain.Account;
import com.sfeir.sgcib.kata.domain.AccountHistoryConsolePrinter;
import com.sfeir.sgcib.kata.domain.AccountHistoryPrinter;

public class AccountHistoryPrinterShouldTest {
	
	private AccountHistoryPrinter accountHistoryPrinter;
	
	@Mock
	private Account account;
	
	@Before
	public void setUp() {
		accountHistoryPrinter = new AccountHistoryConsolePrinter();
		account.executeDepositOperation(500d);
	}
	
	@Test
	public void print_account_statement() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
		String accountStatement = accountHistoryPrinter.printAccountHistory(account);
		
		System.out.flush();
		System.setOut(old);
				
		Assertions.assertThat(baos.toString()).contains(accountStatement);
	}

}
