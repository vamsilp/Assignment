package com.assignement.portfolio.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.assignement.portfolio.PortfolioConstants;

public class PortfolioRuleValidator implements Validator<List<String>>{

	public boolean validate(List<String> rawRules) {
		for (String rawRule : rawRules) {
			if (!validateRule(rawRule)) {
				// validation failed for a rule!
				return false;
			}
		}
		return true;
	} 

	private boolean validateRule(String rawRule) {

		// Will check if there is a blank row
		if (StringUtils.isBlank(rawRule)) {
			return false;
		}

		String[] ruleComponents = StringUtils.split(rawRule, PortfolioConstants.PIPE);

		// Will check if there are not 5 components for a rule text
		if (ruleComponents.length != PortfolioConstants.RULES_COUNT) {
			return false;
		} 

		// Get All the components
		String name = ruleComponents[0].trim();
		String pctEquity = ruleComponents[1].trim();
		String pctBond = ruleComponents[2].trim();
		String pctCash = ruleComponents[3].trim();
		String age = ruleComponents[4].trim();

		// If any of them blank return false
		if (StringUtils.isBlank(name) || StringUtils.isBlank(pctEquity) || StringUtils.isBlank(pctBond)
				|| StringUtils.isBlank(pctCash) || StringUtils.isBlank(age)) {
			return false;
		}

		// Check for any presence of invalid characters for pct components
		if (!validatePercentageComponents(pctEquity) || !validatePercentageComponents(pctBond)
				|| !validatePercentageComponents(pctCash)) {
			return false;
		}

		if (!validateAge(age)) {
			return false;
		}

		return true;
	}
 
	private boolean validateAge(String age) {
		String[] ageRange = StringUtils.split(age, PortfolioConstants.SPACE);
		if (ageRange.length < 2 || ageRange.length > 3) {
			return false;
		}
		// For ages less than 65
		if (ageRange.length == 2) {
			Pattern pattern = Pattern.compile(PortfolioConstants.AGE_RANGE_MATCHER);
			Matcher matcher = pattern.matcher(ageRange[0]);
			return matcher.matches();
		}
		// For ages 65 or more
		if (ageRange.length == 3) {
			if (Integer.valueOf(ageRange[0]) < 65) {
				return false;
			}
		}
		return true;
	}

	private boolean validatePercentageComponents(String pctComponent) {
		Pattern pattern = Pattern.compile(PortfolioConstants.PCT_REGEX_MATHCER);
		Matcher matcher = pattern.matcher(pctComponent);
		return matcher.matches();
	}

}
