package com.assignement.portfolio.validator;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.assignement.portfolio.PortfolioConstants;
import com.assignement.portfolio.dataobject.CustomerData;
import com.assignement.portfolio.exception.ValidationException;

public class CustomerValidator implements Validator<String> {

	@Override
	public boolean validate(String customer) throws Exception {
		
		String[] data = StringUtils.split(customer, '|');
		CustomerData customerData = null;
		if(data.length != 4) {
			throw new ValidationException("Not a valid row!");
		}else {
			customerData = new CustomerData(data[0], data[1], data[2], data[3]);
			customerData.setRowText(customer);
		}
		
		if (!isFirstNameValid(customerData.getFirstName())) {
			throw new ValidationException("First Name not Valid!");
		}
		if (!isLastNameValid(customerData.getLastName())) {
			throw new ValidationException("Last Name not Valid!");
		}
		if (!isDobValid(customerData.getDob().trim())) {
			throw new ValidationException("DOB not Valid!");
		}
		if (!isAssetValid(customerData.getAsset().trim())) {
			throw new ValidationException("Asset not Valid!");
		}
		return true;
	}

	private boolean isAssetValid(String assetStr) {
		if (assetStr.length() > PortfolioConstants.ASSET_LENGTH) {
			return false;
		}
		// Explicit decimal point
		return assetStr.split("\\.|,").length == 2 ? true : false;
	}

	private boolean isDobValid(String dob) {
		if (dob.length() != PortfolioConstants.DOB_LENGTH) {
			return false;
		}
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if (Integer.valueOf(dob.substring(4, 8)) >= PortfolioConstants.MIN_DOB
				&& Integer.valueOf(dob.substring(4, 8)) <= currentYear) { 
			return true;
		}
		return false;
	}

	private boolean isFirstNameValid(String name) {
		Pattern pattern = Pattern.compile(PortfolioConstants.ALPHANUMERIC_REGEX);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches() && name.length() <= PortfolioConstants.FIRST_NAME_LENGTH;
	}

	private boolean isLastNameValid(String name) {
		Pattern pattern = Pattern.compile(PortfolioConstants.ALPHANUMERIC_REGEX);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches() && name.length() <= PortfolioConstants.LAST_NAME_LENGTH;
	}
}
