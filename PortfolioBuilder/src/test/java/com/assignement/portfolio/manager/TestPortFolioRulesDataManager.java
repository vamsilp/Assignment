package com.assignement.portfolio.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.assignement.portfolio.builder.ObjectBuiler;
import com.assignement.portfolio.builder.TestPortFolioRulesBuilder;
import com.assignement.portfolio.domain.Rule;
import com.assignement.portfolio.reader.PortFolioRulesTextReader;
import com.assignement.portfolio.validator.PortfolioRuleValidator;
import com.assignement.portfolio.validator.Validator;

import junit.framework.Assert;

public class TestPortFolioRulesDataManager {
	
	
	private PortFolioRulesDataManager portFolioRulesDataManager;

	@Before
	public void setUp() throws Exception {
		portFolioRulesDataManager = new PortFolioRulesDataManager();
	}

	@Test
	public void testNoValidFiles() throws Exception {
		List<Rule> rules = (portFolioRulesDataManager.getAllSystemRules("src/test/resources/testingFolders/portFolioRules.txt"));
		Assert.assertEquals(rules.get(0).getModelName(), "Aggressive Growth");
		
	}

}
