package com.assignement.portfolio.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import com.assignement.portfolio.calculator.AgePortfolioCalculator;
import com.assignement.portfolio.dataobject.CustomerData;
import com.assignement.portfolio.domain.Customer;
import com.assignement.portfolio.domain.Portfolio;
import com.assignement.portfolio.domain.Rule;

/**
 * 
 * Main Manager for portfolio system. 
 *
 */
public class CustomerPortfolioManager {

	private final static Logger LOGGER = Logger.getLogger(CustomerPortfolioManager.class.getName());

	public int manageCustomerPortfolio(String inputFile, String outputFile, String rulesFile, String errorFile) {
		boolean isFilesValid = false;
		int resultCode = 0; 
		List<Rule> rules = null;
		List<String> exceptions = new ArrayList<>();
		List<String> readCustomersData;
		List<CustomerData> validReadCustomersData;
		CustomerPortfolioDataManger dataMananger = new CustomerPortfolioDataManger();
		PortFolioRulesDataManager rulesManger = new PortFolioRulesDataManager();

		isFilesValid = validateIfFilesAreValid(inputFile, outputFile, rulesFile, errorFile);

		if (!isFilesValid) {
			LOGGER.severe("Invalid file information provided");
			return -1;
		} 
 
		// Get me all rules for running the portfolio
		try {
			rules = rulesManger.getAllSystemRules(rulesFile);
		} catch (Exception ex) {
			StringBuilder exceptionBuilder = new StringBuilder();
			exceptionBuilder.append("Reading Rules failed due to ").append(ExceptionUtils.getFullStackTrace(ex));
			LOGGER.severe(exceptionBuilder.toString());
			return -1;
		}

		// If rules are empty or null do not proceed
		if (CollectionUtils.isEmpty(rules)) {
			return -1;
		}

		// Get me all customer data
		try { 
			readCustomersData = dataMananger.readCustomerData(inputFile);
		} catch (Exception ex) {
			StringBuilder exceptionBuilder = new StringBuilder();
			exceptionBuilder.append("Reading customer data failed due to ")
					.append(ExceptionUtils.getFullStackTrace(ex));
			LOGGER.severe(exceptionBuilder.toString());
			return -1;
		}

		try { 
			// delegate to validate customers [Skip bad ones]
			validReadCustomersData = dataMananger.validateCustomerData(exceptions, readCustomersData);

			// delegate to Build Customer domain List
			List<Customer> validatedCustomers = dataMananger.buildToCustomerDomain(validReadCustomersData);

			// delegate to Calculate all customer and get list of portfolios
			List<Portfolio> portfolios = null;
			if (CollectionUtils.isNotEmpty(validatedCustomers)) {
				portfolios = calculateForEachCustomer(validatedCustomers, rules);
			}

			// delegate to Write to output file
			if (CollectionUtils.isNotEmpty(portfolios)) {
				dataMananger.writeCustomerData(portfolios, outputFile);
				// set processed to true
				resultCode = 0;
			}

			// check for any Skipped record errors
			if (CollectionUtils.isNotEmpty(exceptions)) {
				dataMananger.writeCustomerExceptions(exceptions, errorFile);
				resultCode = CollectionUtils.isNotEmpty(portfolios)? 1 : -1;
			}
		} catch (Exception ex) {
			StringBuilder exceptionBuilder = new StringBuilder();
			exceptionBuilder.append("Unexpected excpetion while managing portfolios ")
					.append(ExceptionUtils.getFullStackTrace(ex));
			LOGGER.severe(exceptionBuilder.toString());
			return -1;
		}

		// Send response back.
		return resultCode;
	}

	//File checker
	private boolean validateIfFilesAreValid(String... files) {
		for (String file : files) {
			if (StringUtils.isBlank(file)) {
				return false;
			}
		}
		return true;
	}

	//Calculator
	private List<Portfolio> calculateForEachCustomer(List<Customer> customers, List<Rule> rules) {
		List<Portfolio> portfolios = new ArrayList<>();
		Portfolio portfolio = null;
		for (Customer customer : customers) {
			AgePortfolioCalculator calculator = new AgePortfolioCalculator();
			portfolio = calculator.calculate(customer, rules);
			if (null != portfolio) {
				portfolios.add(portfolio);
			}
		}
		return portfolios;
	}
}
