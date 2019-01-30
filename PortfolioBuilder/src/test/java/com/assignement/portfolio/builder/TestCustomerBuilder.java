package com.assignement.portfolio.builder;

import org.junit.Before;
import org.junit.Test;

import com.assignement.portfolio.dataobject.CustomerData;

import junit.framework.Assert;

public class TestCustomerBuilder {
	
	private CustomerBuilder customerBuilder;
	
	@Before
	public void setUp() throws Exception {
		customerBuilder = new CustomerBuilder();
	}

	@Test
	public void testCustomerBuilder() throws Exception {
		Assert.assertNotNull(customerBuilder.build(new CustomerData("viswanath","patimalla","01012011","000000839.3345")));
	}
	
}
