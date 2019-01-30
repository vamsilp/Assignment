package com.assignement.portfolio.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDataWriter {

	private final static Logger LOGGER = Logger.getLogger(CustomerDataWriter.class.getName());

	public void writeCustomerData(List<String> customerPortfolio, String qualifiedLocation) throws Exception {
		BufferedWriter bufferWriter = null;
		try {
			File file = new File(qualifiedLocation);
			file.createNewFile();

			FileWriter fw = new FileWriter(file);
			bufferWriter = new BufferedWriter(fw);

			for (String portfolio : customerPortfolio) {
				String portfolioContent = portfolio.toString();
				bufferWriter.write(portfolioContent);
			}

		} catch (Exception ex) {
			StringBuilder errorBuilder = new StringBuilder();
			errorBuilder.append("Error Writing file at location ").append(qualifiedLocation);
			LOGGER.log(Level.SEVERE, "Error Writing to output Text File");
			throw ex;
		} finally {
			bufferWriter.close();
		}
	}
}