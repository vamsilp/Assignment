package com.assignement.portfolio.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.assignement.portfolio.PortfolioConstants;
import com.assignement.portfolio.validator.CustomerValidator;

import junit.framework.Assert;

public class TestCustomerDataReader {

	private CustomerDataReader customerDataReader;

	@Before
	public void setUp() throws Exception {
		customerDataReader = new CustomerDataReader();
	}

	@Test
	public void testCustomerReaderPositiveScenario() throws Exception {
		try {
			customerDataReader.readCustomerData("src/test/resources/FileTesting/Input.txt");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}

	@Test(expected = NullPointerException.class)
	public void testCustomerReaderNegativeScenario() throws Exception {
		customerDataReader.readCustomerData("srcc/test/resources/FileTesting/Input.txt");
	}
}