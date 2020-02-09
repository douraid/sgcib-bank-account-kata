package com.sfeir.sgcib.kata.test.acceptance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author Douraid
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = {
		"pretty", "html:target/cucumber-reports" }, monochrome = true, snippets = SnippetType.CAMELCASE)
public class AccountOperationsTest {
 }
