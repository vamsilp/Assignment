package com.assignement.portfolio.writer;

import java.util.ArrayList;
import java.util.List;

import org.easymock.internal.matchers.InstanceOf;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestCustomerDataWriter {

	private CustomerDataWriter writer;

	@Before
	public void setUp() throws Exception {
		writer = new CustomerDataWriter();
	}

	@Test
	public void testCustomerWriterPostiveScenario() {
		List<String> customerPortfolio = new ArrayList<>();
		customerPortfolio.add("TestScenario");
		try {
			writer.writeCustomerData(customerPortfolio, "src/test/resources/FileTesting/Input.txt");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);

	}

	@Test(expected = NullPointerException.class)
	public void testCustomerWriterExceptionScenarioAccesingTheFile() throws Exception {
		List<String> customerPortfolio = new ArrayList<>();
		customerPortfolio.add("TestScenario");
		writer.writeCustomerData(customerPortfolio, "srcc/test/resources/FileTesting/Input.txt");
	}
}