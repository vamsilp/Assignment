package com.assignement.portfolio.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import com.assignement.portfolio.PortfolioConstants;
import com.assignement.portfolio.builder.CustomerBuilder;
import com.assignement.portfolio.builder.ObjectBuiler;
import com.assignement.portfolio.dataobject.CustomerData;
import com.assignement.portfolio.dataobject.TestCustomerData;
import com.assignement.portfolio.domain.Customer;
import com.assignement.portfolio.domain.Portfolio;
import com.assignement.portfolio.exception.ValidationException;
import com.assignement.portfolio.reader.CustomerDataReader;
import com.assignement.portfolio.validator.CustomerValidator;
import com.assignement.portfolio.validator.Validator;
import com.assignement.portfolio.writer.CustomerDataWriter;

public class CustomerPortfolioDataManger {

	public List<String> readCustomerData(String qualifiedLocation) throws Exception {
		CustomerDataReader csvReader = new CustomerDataReader();
		return csvReader.readCustomerData(qualifiedLocation);
	}
 
	public void writeCustomerData(List<Portfolio> customerPortfolio, String qualifiedLocation) throws Exception {
		List<String> portfolioData = new ArrayList<>();
		CustomerDataWriter customerDataWriter = new CustomerDataWriter();
		StringBuilder portfolioBuilder = null;
			for (Portfolio portfolio : customerPortfolio) {
				portfolioBuilder = new StringBuilder();
				portfolioBuilder.append(portfolio.getLastName()).append(portfolio.getFirstName())
						.append(StringUtils.rightPad(portfolio.getPortfolioName(), 20, PortfolioConstants.SPACE))
						.append(System.lineSeparator());
				portfolioData.add(portfolioBuilder.toString());
			}
		customerDataWriter.writeCustomerData(portfolioData, qualifiedLocation);
	}

	public List<Customer> buildToCustomerDomain(List<CustomerData> validReadCustomersData) {
		List<Customer> validatedCustomers = null;
		if (CollectionUtils.isNotEmpty(validReadCustomersData)) {
			ObjectBuiler customerBuilder = new CustomerBuilder();
			validatedCustomers = new ArrayList<>(); 
			for (CustomerData customerData : validReadCustomersData) {
				Customer customer = (Customer) customerBuilder.build(customerData);
				validatedCustomers.add(customer);
			}
		}
		return validatedCustomers;
	} 

	public List<CustomerData> validateCustomerData(List<String> exceptions, List<String> readCustomersData) {
		List<CustomerData> validReadCustomersData;
		validReadCustomersData = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(readCustomersData)) {
			Validator customerValidator = new CustomerValidator();
			for (String customerData : readCustomersData) {
				try {
					if (customerValidator.validate(customerData)) {
						String[] data = StringUtils.split(customerData, '|');
						validReadCustomersData.add(new CustomerData(data[0], data[1], data[2], data[3]));
					}
					// [Add exceptions to exception list]
				} catch (ValidationException ve) {
					StringBuilder exceptionBuilder = new StringBuilder();
					exceptionBuilder.append(System.lineSeparator()).append("Validation failed! ")
							.append(ExceptionUtils.getFullStackTrace(ve)).append("for raw input")
							.append(PortfolioConstants.SPACE)
							.append(StringUtils.remove(customerData, PortfolioConstants.PIPE));
					exceptions.add(exceptionBuilder.toString());
				} catch (Exception ex) {
					StringBuilder exceptionBuilder = new StringBuilder();
					exceptionBuilder.append(System.lineSeparator()).append("Unexpected exception ! ")
							.append(ExceptionUtils.getFullStackTrace(ex)).append("for raw input")
							.append(PortfolioConstants.SPACE)
							.append(StringUtils.remove(customerData, PortfolioConstants.PIPE));
					exceptions.add(exceptionBuilder.toString());
				}
			}
		}
		return validReadCustomersData;
	}

	public void writeCustomerExceptions(List<String> exceptions, String qualifiedLocation) throws Exception {
		CustomerDataWriter customerDataWriter = new CustomerDataWriter();
		customerDataWriter.writeCustomerData(exceptions, qualifiedLocation);
	}
}
