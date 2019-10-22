package com.atmecs.Konakart.utils;

import java.io.File;
/*
 * This Class used to define paths for all files.
 *
 *  
 *  @author   Magesh S
*/

public class Classpaths {

	public static String Users_Home = System.getProperty("user.dir");

	public static String url_file = Users_Home + File.separator + "config.properties";

	public static String resource_file = Users_Home + File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator + "com" + File.separator + "atmecs" + File.separator + "application";

	public static String log4j_file = resource_file + File.separator + "log4j"
			+ File.separator + "log4j.properties";

	public static String Excel_file_one = resource_file + File.separator + "datavalues" + File.separator
			+ "datavalue.xlsx";

	public static String loc_file = resource_file + File.separator + "locators" + File.separator
			+ "konakarthome.properties";

	public static String loc_file_two = resource_file + File.separator + "locators" + File.separator
			+ "konakarthero.properties";

	public static String Chrome_file = Users_Home + File.separator + "lib" + File.separator + "chromedriver.exe";

	public static String Firefox_file = Users_Home + File.separator + "lib" + File.separator + "geckodriver.exe";

	public static String IE_file = Users_Home + File.separator + "lib" + File.separator + "IEDriverServer.exe";

	public static String Edge_file = Users_Home + File.separator + "lib" + File.separator + "MicrosoftWebDriver.exe";

	public static String extendreport = Users_Home + File.separator + "extendedreport" + File.separator;
	/*
	 * public static void main(String[] args) { System.out.println(log4j_file); }
	 */
}
