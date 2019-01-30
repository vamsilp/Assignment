package com.assignement.portfolio.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.assignement.portfolio.dataobject.CustomerData;
import com.assignement.portfolio.dataobject.TestCustomerData;
import com.assignement.portfolio.domain.Portfolio;

import junit.framework.Assert;

public class TestCustomerPortfolioDataManger {
	
	private CustomerPortfolioDataManger customerPortfolioDataManger;

	@Before
	public void setUp() throws Exception {
		customerPortfolioDataManger = new CustomerPortfolioDataManger();
	}

	@Test
	public void testReadCustomerDataPositiveScenario() throws Exception {
		try {
			customerPortfolioDataManger.readCustomerData("src/test/resources/FileTesting/Input.txt");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	} 
	
	@Test
	public void testWriteCustomerPortfolioDataPositiveScenario() throws Exception {
		try {
			List<Portfolio> customerPortfolio = new ArrayList<>();
			Portfolio portfolio = new Portfolio();
			portfolio.setFirstName("fname");
			portfolio.setLastName("lname");
			portfolio.setPortfolioName("pfOne");
			customerPortfolioDataManger.writeCustomerData(customerPortfolio,"src/test/resources/FileTesting/Input2.txt");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void testWriteEmptyCustomerPortfolioDataPositiveScenario() throws Exception {
		try {
			List<Portfolio> customerPortfolio = new ArrayList<>();
			customerPortfolioDataManger.writeCustomerData(customerPortfolio,"src/test/resources/FileTesting/Input2.txt");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void testWriteMultipleCustomerPortfolioDataPositiveScenario() throws Exception {
		try {
			List<Portfolio> customerPortfolio = new ArrayList<>();
			Portfolio portfolio = new Portfolio();
			portfolio.setFirstName("fname");
			portfolio.setLastName("lname");
			portfolio.setPortfolioName("pfOne");
			customerPortfolio.add(portfolio);
			customerPortfolioDataManger.writeCustomerData(customerPortfolio,"src/test/resources/FileTesting/Input2.txt");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void testbuildToCustomerDomainDataPositiveScenario() throws Exception {
		try {
			List<CustomerData> validReadCustomersData = new ArrayList<>();
			CustomerData testCustomerData = new CustomerData("viswanath ", "patimalla ","01012012","000000345345.3");
			validReadCustomersData.add(testCustomerData);
			customerPortfolioDataManger.buildToCustomerDomain(validReadCustomersData);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void testEmptybuildToCustomerDomainDataPositiveScenario() throws Exception {
		try {
			List<CustomerData> validReadCustomersData = new ArrayList<>();
			customerPortfolioDataManger.buildToCustomerDomain(validReadCustomersData);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void testvalidateCustomerDataPositiveScenario() throws Exception {
			List<String> exceptions= new ArrayList<>(); List<String> readCustomersData= new ArrayList<>();
			readCustomersData.add("viswanath patimalla 01102011000000022.2");
		    readCustomersData.add("v         p         012519780000002.222");
		    List<CustomerData> customers = customerPortfolioDataManger.validateCustomerData(exceptions,readCustomersData);
		    Assert.assertNotNull(customers);
		
	}
	
	@Test
	public void testvalidateCustomerDataNegativeScenarioNoAges() throws Exception {
			List<String> exceptions= new ArrayList<>(); List<String> readCustomersData= new ArrayList<>();
		    readCustomersData.add("v         p         ");
		    List<CustomerData> customers = customerPortfolioDataManger.validateCustomerData(exceptions,readCustomersData);
		    Assert.assertNotNull(customers);
	}
	
	@Test
	public void testvalidateCustomerDataNegativeScenarioNoAmountsInvalidDOB() throws Exception {
			List<String> exceptions= new ArrayList<>(); List<String> readCustomersData= new ArrayList<>();
		    readCustomersData.add("v     |    p    | @##$$ |   ");
		    customerPortfolioDataManger.validateCustomerData(exceptions,readCustomersData);
		    Assert.assertTrue(!exceptions.isEmpty());
	}
	
	@Test
	public void testWriteCustomerExceptions() throws Exception {
			List<String> exceptions= new ArrayList<>();
			exceptions.add("Invliad customer DOB!");
		    customerPortfolioDataManger.writeCustomerExceptions(exceptions,"src/test/resources/FileTesting/Error.txt");
	}
	 
	 
	 
	
}
