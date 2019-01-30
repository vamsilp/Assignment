package com.assignement.portfolio;


public class PortfolioConstants {

	public static int RULES_COUNT = 5;
	public static String PCT_REGEX_MATHCER = "^\\d{1,5}%";
	public static char SPACE = ' ';
	public static char PIPE = '|';
	public static String AGE_RANGE_MATCHER = "^\\d{1,2}-\\d{1,2}";
	public static Integer SENIOR_AGE_START= 65;
	public static Integer SENIOR_MAX_AGE= 150;
	public static String ALPHANUMERIC_REGEX = "^[a-zA-Z0-9 ]*$";
	public static String DECIMAL_REGEX = "^\\d+(.\\d+){0,1}$";
	public static int FIRST_NAME_LENGTH = 10;
	public static int LAST_NAME_LENGTH = 10;
	public static int DOB_LENGTH = 8;
	public static int ASSET_LENGTH = 12;
	public static int MIN_DOB = 1850;
	public static int ASSET_DECIMAL_ROUNDING = 2;
	public static String DOB_FORMAT = "MMddyyyy";
	public static int[] INPUT_FILE_DELIMITER_POSITIONS = {10,20,28,40};
	
}


