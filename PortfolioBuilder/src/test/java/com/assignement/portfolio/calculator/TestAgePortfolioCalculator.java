package com.assignement.portfolio.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import com.assignement.portfolio.PortfolioConstants;
import com.assignement.portfolio.domain.Customer;
import com.assignement.portfolio.domain.Portfolio;
import com.assignement.portfolio.domain.Rule;

import junit.framework.Assert;

/**
 * 
 * Main Calculator class
 *
 */
public class TestAgePortfolioCalculator {

	private AgePortfolioCalculator agePortfolioCalculator;

	@Before
	public void setUp() throws Exception {
		agePortfolioCalculator = new AgePortfolioCalculator();
	}

	@Test
	public void testNoValidFiles() throws Exception {
		DateTimeFormatter format = org.joda.time.format.DateTimeFormat.forPattern(PortfolioConstants.DOB_FORMAT);
		LocalDate date = org.joda.time.LocalDate.parse("12121999", format);
		Customer customer = new Customer("ABC", "DEF", date, new BigDecimal(32.32));
		List<Rule> rules = new ArrayList<>();
		Rule ruleOne = new Rule("Aggresive Growth", new BigDecimal(3.33), new BigDecimal(3.33), new BigDecimal(3.33), 0,
				40);
		Rule ruleTwo = new Rule("Retire", new BigDecimal(3.33), new BigDecimal(3.33), new BigDecimal(3.33), 65, 150);
		rules.add(ruleOne);
		rules.add(ruleTwo);
		Portfolio portfolio = (agePortfolioCalculator.calculate(customer, rules));
		Assert.assertEquals(portfolio.getPortfolioName(), ruleOne.getModelName());

	}

}
