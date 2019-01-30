package com.assignement.portfolio.manager;

import java.util.ArrayList;
import java.util.List;

import com.assignement.portfolio.builder.ObjectBuiler;
import com.assignement.portfolio.builder.PortFolioRulesBuilder;
import com.assignement.portfolio.domain.Rule;
import com.assignement.portfolio.reader.PortFolioRulesTextReader;
import com.assignement.portfolio.validator.PortfolioRuleValidator;
import com.assignement.portfolio.validator.Validator;

public class PortFolioRulesDataManager {

	public List<Rule> getAllSystemRules(String qualifiedLocation) throws Exception {
		List<Rule> rules = new ArrayList<>();

		PortFolioRulesTextReader portfolioReader = new PortFolioRulesTextReader();
		List<String> rawRules = portfolioReader.readData(qualifiedLocation);

		Validator rulesValidator = new PortfolioRuleValidator();
		boolean rulePassed = rulesValidator.validate(rawRules);

		if (rulePassed) {
			ObjectBuiler ruleBuilder = new PortFolioRulesBuilder();
			rules = (List<Rule>) ruleBuilder.build(rawRules);
		}

		return rules;
	}
}
