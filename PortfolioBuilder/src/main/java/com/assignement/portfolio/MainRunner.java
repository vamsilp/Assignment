package com.assignement.portfolio;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.assignement.portfolio.manager.CustomerPortfolioManager;

/**
 * Hello portfolio!
 * Ran with Eclipse prog arguments as
 * Input/inputData.txt
   Output/outputFile.txt 
   Input/portFolioRules.txt
   Output/Exception.txt
 *
 */
public class MainRunner {
	private final static Logger LOGGER = Logger.getLogger(MainRunner.class.getName());

	public static void main(String[] args) {
		LOGGER.info("Starting process to calculate portfolio of the customers");
		CustomerPortfolioManager manager = new CustomerPortfolioManager();
		int resultsCode = manager.manageCustomerPortfolio(args[0], args[1], args[2], args[3]);
		if (resultsCode == 0) {
			LOGGER.log(Level.INFO, "Portfolios processed succesfully!");
			System.exit(resultsCode);
		} else if (resultsCode == 1) {
			LOGGER.log(Level.WARNING, "System processed portfolios with some errors, please check logs or Exception File");
			System.exit(resultsCode);
		} else {
			LOGGER.log(Level.SEVERE, "System did not run, please check logs or Exception File");
			System.exit(resultsCode);
		}
	}
}
