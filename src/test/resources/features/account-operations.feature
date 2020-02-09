Feature: Account operations

	Scenario: Deposit Some funds
	  Given I deposit 2000 euros
      When I ask the account statement
      Then My account's balance should be 2000 euros
    
    
    Scenario: Multiple deposits/withdrawals
      Given I deposit 3000 euros
      And I deposit 400 euros
      And I withdraw 150 euros
      When I ask the account statement
      Then My account's balance should be 3250 euros
      
    Scenario: Illegal debit should fails
      Given I deposit 200 euros
      And I withdraw 300 euros
      When I ask the account statement
      Then My account's balance should be 200 euros