package com.assignement.portfolio.dataobject;

import org.junit.Before;
import org.junit.Test;

import com.assignement.portfolio.builder.CustomerBuilder;

import junit.framework.Assert;

public class TestCustomerData {
	
	CustomerData customerData = new CustomerData();
	@Before
	public void setUp() throws Exception {
		customerData = new CustomerData();
	}
	
	@Test
	public void testCustomerData() {
		customerData.setAsset("00000.232");
		customerData.setDob("12121933");
		customerData.setFirstName("firstName");
		customerData.setLastName("lastName");
		Assert.assertEquals(customerData.getAsset(), "00000.232");
		Assert.assertEquals(customerData.getDob(), "12121933");
		Assert.assertEquals(customerData.getFirstName(), "firstName");
		Assert.assertEquals(customerData.getLastName(), "lastName");
	}
}

