package com.assignement.portfolio.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang.exception.ExceptionUtils;

public class PortFolioRulesTextReader {

	public List<String> readData(String qualifiedLocation) throws Exception {
		List<String> rulesText = new ArrayList<>();
		Scanner scanner = null;
		try {
			File file = new File(qualifiedLocation);
			scanner = new Scanner(file);
			int lineCounter = 0;
			while (scanner.hasNextLine()) {
				if (lineCounter > 1) {
					rulesText.add(scanner.nextLine());
				} else {
					scanner.nextLine();
				}
				++lineCounter;
			}

		} catch (Exception ex) {
			// throw Exception here as process will halt when rules are not read.
			throw new Exception("Unable to read rules file " + ExceptionUtils.getFullStackTrace(ex));
		} finally {
			scanner.close();
		}
		return rulesText;
	}
}