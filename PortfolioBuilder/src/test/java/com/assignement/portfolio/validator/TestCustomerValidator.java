package com.assignement.portfolio.validator;

import org.junit.Before;
import org.junit.Test;

import com.assignement.portfolio.exception.ValidationException;

import junit.framework.Assert;

public class TestCustomerValidator {

	private CustomerValidator customerValidator;

	@Before
	public void setUp() throws Exception {
		customerValidator = new CustomerValidator();
	}

	@Test
	public void testCustomerValidatorValidCustomer() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis      |pat      |10102018|0000000.223"));
	}
	
	@Test(expected = ValidationException.class)
	public void testCustomerValidatorValidCustomerInvalidOne() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis!12234234234|pat      |10102018|0000000.223"));
	}
	
	@Test(expected = ValidationException.class)
	public void testCustomerValidatorValidCustomerInvalidFnameLength() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis345312234234234|pat      |10102018|0000000.223"));
	}
	
	@Test(expected = ValidationException.class)
	public void testCustomerValidatorValidCustomerInvalidLnameLength() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis      |patertertet34534535|10102018|0000000.223"));
	}
	
	@Test(expected = ValidationException.class)
	public void testCustomerValidatorValidCustomerInvalidLength() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis |pat      |"));
	}
	
	@Test(expected = ValidationException.class)
	public void testCustomerValidatorValidCustomerInvalidSeconfNam() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis      |pat123123!|10102018|0000000.223"));
	}

	@Test(expected = ValidationException.class)
	public void testCustomerValidatorInValidCustomerName() throws Exception {
		customerValidator.validate("-vis-    |pat      |10102018|0000000.223");
	}

	@Test(expected = ValidationException.class)
	public void testCustomerValidatorInValidCustomerFutureAge() throws Exception {
		customerValidator.validate("vis    |pat      |10102111|0000000.223");
	}

	@Test(expected = ValidationException.class)
	public void testCustomerValidatorInValidCustomerAssetNoDecimalPoint() throws Exception {
		customerValidator.validate("vis    |pat      |10102001|0000000223");
	}
	
	@Test(expected = ValidationException.class)
	public void testCustomerValidatorInValidCustomerAssetLength() throws Exception {
		customerValidator.validate("vis    |pat      |10102001|0000000223234234234.0000456");
	}
	
	@Test(expected = ValidationException.class)
	public void testCustomerValidatorValidCustomerInvalidDOB() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis      |pat      |10102035318|0000000.223"));
	}
	
	@Test
	public void testCustomerValidatorValidCustomerDOBLessThan150() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis      |pat      |10102001|0000000.223"));
	}
	
	@Test(expected = ValidationException.class)
	public void testCustomerValidatorValidCustomerDOBGreaterThan150() throws Exception {
		Assert.assertTrue(customerValidator.validate("vis      |pat      |10101801|0000000.223"));
	}

}
