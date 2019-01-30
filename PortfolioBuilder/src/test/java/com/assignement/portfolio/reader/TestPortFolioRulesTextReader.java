package com.assignement.portfolio.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestPortFolioRulesTextReader {
	
	private PortFolioRulesTextReader portFolioRulesTextReader;

	@Before
	public void setUp() throws Exception {
		portFolioRulesTextReader = new PortFolioRulesTextReader();
	}

	@Test
	public void testPortFolioRulesTextReaderPositiveScenario() throws Exception {
		try {
			portFolioRulesTextReader.readData("src/test/resources/FileTesting/Input.txt");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCustomerReaderNegativeScenario() throws Exception {
		portFolioRulesTextReader.readData("srcc/test/resources/FileTesting/Input.txt");
	}
}