package com.assignement.portfolio.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.assignement.portfolio.PortfolioConstants;
import com.assignement.portfolio.domain.Rule;

public class PortFolioRulesBuilder implements ObjectBuiler<List<String>, List<Rule>>{

	@Override 
	public List<Rule> build(List<String> rawRules) {
		List<Rule> rules = new ArrayList<>();
		for (String rawRule : rawRules) {
			String[] ruleComponents = StringUtils.split(rawRule, PortfolioConstants.PIPE);
			// Get All the components
			String name = ruleComponents[0].trim();
			int startAge = 0, endAge = 0;
			BigDecimal pctEquity = new BigDecimal(ruleComponents[1].trim().replace("%", ""))
					.divide(BigDecimal.valueOf(100));
			BigDecimal pctBond = new BigDecimal(ruleComponents[2].trim().replace("%", ""))
					.divide(BigDecimal.valueOf(100));
			BigDecimal pctCash = new BigDecimal(ruleComponents[3].trim().replace("%", ""))
					.divide(BigDecimal.valueOf(100));
			String[] ages = getAgeRange(ruleComponents[4].trim());
			if (ages.length > 0) {
				startAge = Integer.valueOf(ages[0]);
				endAge = Integer.valueOf(ages[1]);
			}
			Rule rule = new Rule(name, pctEquity, pctBond, pctCash, startAge, endAge);
			rules.add(rule);
		}
		return rules;
	}

	private String[] getAgeRange(String age) {
		String[] ageRange = StringUtils.split(age, PortfolioConstants.SPACE);
		// For ages less than 65
		if (ageRange.length == 2) {
			String[] ages = StringUtils.split(ageRange[0],'-');
			return ages;
		}
		// For ages 65 or more
		if (ageRange.length == 3) {
			return new String[] { ageRange[0], String.valueOf(PortfolioConstants.SENIOR_MAX_AGE) };
		}
		return new String[] {};
	}
}
