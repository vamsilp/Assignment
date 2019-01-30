package com.assignement.portfolio.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.assignement.portfolio.PortfolioConstants;
import com.assignement.portfolio.dataobject.TestCustomerData;
import com.assignement.portfolio.domain.Rule;

import junit.framework.Assert;

public class TestPortFolioRulesBuilder {

	private PortFolioRulesBuilder portFolioRulesBuilder;

	@Before
	public void setUp() throws Exception {
		portFolioRulesBuilder = new PortFolioRulesBuilder();
	}

	@Test
	public void testPortFolioRulesBuilderPostive() throws Exception {
		List<String> rawRules = new ArrayList<>();
		rawRules.add("|Aggressive Growth	|80%				|10%				|10%				|0-40 Years			|");
		Assert.assertNotNull(
				portFolioRulesBuilder.build(rawRules));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testPortFolioRulesBuilderNoAgeMentioned() throws Exception {
		List<String> rawRules = new ArrayList<>();
		rawRules.add("|Aggressive Growth	|80%				|10%				|10%				");
		Assert.assertNotNull(
				portFolioRulesBuilder.build(rawRules));
	}
	
	@Test
	public void testPortFolioRulesBuilderValidAgeMentioned() throws Exception {
		List<String> rawRules = new ArrayList<>();
		rawRules.add("|Aggressive Growth	|80%				|10%				|10%|	65 or older|			");
		Assert.assertNotNull(
				portFolioRulesBuilder.build(rawRules));
	}
	
	@Test
	public void testPortFolioRulesBuilderInvalidAgeMentioned() throws Exception {
		List<String> rawRules = new ArrayList<>();
		rawRules.add("|Aggressive Growth	|80%				|10%				|10%|	65 65 or older|			");
		Assert.assertNotNull(
				portFolioRulesBuilder.build(rawRules));
	}

}
