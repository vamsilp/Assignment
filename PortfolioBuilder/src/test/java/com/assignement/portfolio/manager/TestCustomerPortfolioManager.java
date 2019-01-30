package com.assignement.portfolio.manager;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestCustomerPortfolioManager {

	private CustomerPortfolioManager customerPortfolioManager;

	@Before
	public void setUp() throws Exception {
		customerPortfolioManager = new CustomerPortfolioManager();
	}

	@Test
	public void testNoValidFiles() throws Exception {
		Assert.assertTrue(customerPortfolioManager.manageCustomerPortfolio("src/test/resources/FileTesting/Input.txt",
				"", "", "") == -1);
	}

	@Test
	public void testInvalidValidFilesOne() throws Exception {
		Assert.assertTrue(customerPortfolioManager.manageCustomerPortfolio("src/test/resources/FileTesting/Input.txt",
				"", "","src/test/resources/FileTesting/Input.txt") == -1);
	}

	@Test
	public void testInvalidValidFilestwo() throws Exception {
		Assert.assertTrue(
				customerPortfolioManager.manageCustomerPortfolio("src/test/resources/FileTesting/Input.txt", "",null,null) == -1);
	}
 
	@Test
	public void testValidFiles() throws Exception {
		Assert.assertTrue(customerPortfolioManager.manageCustomerPortfolio("src/test/resources/testingFolders/inputData.txt",
				"src/test/resources/testingFolders/Output.txt", "src/test/resources/testingFolders/portFolioRules.txt",
				"src/test/resources/testingFolders/Error.txt") ==0);
	}
	
	@Test
	public void testInValidSystemRulesFiles() throws Exception {
		Assert.assertTrue(customerPortfolioManager.manageCustomerPortfolio("src/test/resources/testingFolders/inputData.txt",
				"src/test/resources/testingFolders/Output.txt", "src/test/resources/testingFolders/portFolioRulesInvalid.txt",
				"src/test/resources/testingFolders/Error.txt") ==-1);
	}
	
	@Test
	public void testInValidInputFiles() throws Exception {
		Assert.assertTrue(customerPortfolioManager.manageCustomerPortfolio("src/test/resources/testingFolders/invalidInputData.txt",
				"src/test/resources/testingFolders/Output.txt", "src/test/resources/testingFolders/portFolioRules.txt",
				"src/test/resources/testingFolders/Error.txt") ==-1);
	}

}
