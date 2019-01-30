package com.assignement.portfolio.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.assignement.portfolio.PortfolioConstants;

public class CustomerDataReader {

	private final static Logger LOGGER = Logger.getLogger(CustomerDataReader.class.getName());

	public List<String> readCustomerData(String qualifiedLocation) throws Exception {
		Scanner sc = null;
		List<String> customersData = new ArrayList<>();
		try {
			File file = new File(qualifiedLocation);
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				customersData.add(parseText(sc.nextLine()));
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error Reading Input Text File");
			throw e; 
		} finally {
			sc.close();
		}
		return customersData;
	}

	private String parseText(String rowText) throws IOException {
		int[] pos = PortfolioConstants.INPUT_FILE_DELIMITER_POSITIONS;
		BufferedReader buffer = new BufferedReader(new StringReader(rowText));
		int ch = 0;
		int position = 0;
		int index = 0;
		StringBuilder charRow = new StringBuilder();
		StringBuilder chars = new StringBuilder();
		while ((ch = buffer.read()) != -1 && position <= 40) {
			char character = (char) ch;
			position = position + 1;
			if (position <= pos[index]) {
				chars.append(character);
			} else {
				index = index + 1;
				charRow.append(chars.toString()).append('|');
				chars = new StringBuilder();
				chars.append(character);
			}
		}
		charRow.append(chars.toString());
		return charRow.toString();
	}
}