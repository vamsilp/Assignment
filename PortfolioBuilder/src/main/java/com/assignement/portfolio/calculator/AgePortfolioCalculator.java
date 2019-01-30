package com.assignement.portfolio.calculator;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import com.assignement.portfolio.domain.Customer;
import com.assignement.portfolio.domain.Portfolio;
import com.assignement.portfolio.domain.Rule;
/**
 * 
 * Main Calculator class
 *
 */
public class AgePortfolioCalculator { 

	public AgePortfolioCalculator() {
	}

	public Portfolio calculate(Customer customer, List<Rule> rules) {
		Portfolio portfolio = null;
		int age = calculateCurrentAge(customer.getDob());
		for (Rule rule : rules) {
			if (age >= rule.getStartAge() && age <= rule.getEndAge()) {
				portfolio = new Portfolio(customer.getFirstName(), customer.getLastName(), rule.getModelName());
			}
		}
		return portfolio;
	}

	private int calculateCurrentAge(LocalDate dateOfBirth) {
		Years age = Years.yearsBetween(dateOfBirth, new LocalDate());
		return age.getYears();
	}
}
