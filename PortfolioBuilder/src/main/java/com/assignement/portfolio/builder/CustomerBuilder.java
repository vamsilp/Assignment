package com.assignement.portfolio.builder;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;

import com.assignement.portfolio.PortfolioConstants;
import com.assignement.portfolio.dataobject.CustomerData;
import com.assignement.portfolio.dataobject.TestCustomerData;
import com.assignement.portfolio.domain.Customer;

public class CustomerBuilder implements ObjectBuiler<CustomerData, Customer> {

	@Override
	public Customer build(CustomerData customerData) {
		Customer customer = new Customer();
		customer.setFirstName(customerData.getFirstName());
		customer.setLastName(customerData.getLastName());
		customer.setDob(buildJodaDate(customerData.getDob()));
		BigDecimal asset = new BigDecimal(customerData.getAsset().trim());
		asset = asset.setScale(PortfolioConstants.ASSET_DECIMAL_ROUNDING, BigDecimal.ROUND_HALF_EVEN);
		customer.setAsset(asset);
		return customer;
	}

	private LocalDate buildJodaDate(String dob) {
		DateTimeFormatter format = org.joda.time.format.DateTimeFormat.forPattern(PortfolioConstants.DOB_FORMAT);
		return org.joda.time.LocalDate.parse(dob, format);
	}
}
