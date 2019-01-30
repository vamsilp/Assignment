package com.assignement.portfolio.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestPortfolioRuleValidator {

	private PortfolioRuleValidator portfolioRuleValidator;

	@Before
	public void setUp() throws Exception {
		portfolioRuleValidator = new PortfolioRuleValidator();
	}

	@Test
	public void testPortfolioRuleValidatorValidRule() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%				|0-40 Years			|");
		Assert.assertTrue(portfolioRuleValidator.validate(rules));
	}

	@Test
	public void testPortfolioRuleValidatorBlankRule() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add("                  ");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}

	@Test
	public void testPortfolioRuleValidatorInvalidRule() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%				|0-40 Years			|0-40 Years			|");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}

	@Test
	public void testPortfolioRuleValidatorInvalidRuleCashPct() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10!%				|0-40 Years			");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}

	@Test
	public void testPortfolioRuleValidatorInvalidRuleBnsPct() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|-10%				|10%				|0-40 Years			");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}

	@Test
	public void testPortfolioRuleValidatorInvalidRuleEquityPct() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|(80)%				|10%				|10%				|0-40 Years			");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}

	@Test
	public void testPortfolioRuleValidatorEmptyRuleComponents() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add("|	|80%				|				|10%				|			");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}

	@Test(expected = NumberFormatException.class)
	public void testPortfolioRuleInvalidRuleAgeBelow65() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%				|0-40 40 Years			|");
		portfolioRuleValidator.validate(rules);
	}

	@Test
	public void testPortfolioRuleInvalidRuleAgeAbove65() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%				|55 65 Years			|");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}

	@Test
	public void testPortfolioRulInvalidValidRuleAgeWith65() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|				|10%				|65 Years			|");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}

	@Test
	public void testPortfolioRuleValidRuleAgeBelow65() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%				|0-40 Years			|");
		Assert.assertTrue(portfolioRuleValidator.validate(rules));
	}
	
	@Test
	public void testPortfolioRuleValidRuleAgeBelow65NegSecanrio() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%				|0-40 0-40 0-40 Years			|");
		portfolioRuleValidator.validate(rules);
	}
	
	@Test
	public void testPortfolioRuleValidRuleAgeBelow65NegSecanrioTwo() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%				|Years			|");
		portfolioRuleValidator.validate(rules);
	}
	
	@Test
	public void testPortfolioRuleValidRule65AndOlder() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%				|65 And Older			|");
		Assert.assertTrue(portfolioRuleValidator.validate(rules));
	}
	
	@Test
	public void testPortfolioRuleValidRuleWithInvalidAge65AndOlder() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|				|75 75 And Older			|");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}
	
	@Test
	public void testPortfolioRuleValidRuleWithInvalidAge65AndOlder2() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|80%				|10%				|10%							|");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}
	
	@Test
	public void testPortfolioRuleInvalidRuleNoEquityPct() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|				|10%				|				|55 Years			|");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}
	
	@Test
	public void testPortfolioRuleInvalidRuleNoAge() throws Exception {
		List<String> rules = new ArrayList<>();
		rules.add(
				"|Aggressive Growth	|				|10%				|10%							");
		Assert.assertFalse(portfolioRuleValidator.validate(rules));
	}
}
