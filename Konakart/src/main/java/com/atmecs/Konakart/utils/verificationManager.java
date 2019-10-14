package com.atmecs.Konakart.utils;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.Konakart.reports.log4j;

public class verificationManager {
	public static log4j log4jobject = new log4j();
	static Logger log = Logger.getLogger("Config files");
	static XlxsReader xlxsreader = utilityFiles.getXlsReader(Classpaths.Excel_file_one);

	public void assertequals(String actual, List<WebElement> expected, String message) {
		log.info("Performing assertion");
		Assert.assertEquals(actual, expected, message);
		log.info(message);
	}

	public static List<String> Splittext(String element, String text) {
		log.info("splittext performs");
		String data = text;
		String[] contents = data.split(element);
		List<String> list = new ArrayList<String>();
		for (String arr : contents)
			list.add(arr);
		log.info("text splitted");
		return list;

	}

	public static String dataresult(String sheetno, String sheetname, int index) {
		log.info("Getting Value from an testdata");
		String dataname = xlxsreader.getCellDataByColumnName(sheetno, sheetname, index);
		log.info(dataname);
		return dataname;
	}

	public static String datares(String sheetno, String sheetname, int index) {
		log.info("Getting Value from an testdata");
		String dataname = xlxsreader.getCellDataByColumnName(sheetno, sheetname, index);
		log.info(dataname);
		return dataname;
	}

	public static void assertequals(String actual, String expected, String message) {
		log.info("Assertion Starts");
		Assert.assertEquals(actual, expected, "Assert not equals");
		log.info(message);
		log.info("Assertion ends");
	}

	public String locateactualval(String sheet, String name, int index) {
		log.info("Getting Value from an testdata");
		String value = xlxsreader.getCellDataByColumnName(sheet, name, index);
		log.info("Expected " + value);
		return value;
	}

	public boolean verifyTrue(boolean condition, String message) {
		boolean result = false;
		try {
			Assert.assertTrue(condition);
			log.info("PASS : " + message);
			System.out.println("PASS : " + message);
			// Reporter.log("PASS : " + message);
			result = true;
		} catch (AssertionError assertionError) {

			result = false;
		}
		return result;

	}

	public static void assertmatch(String actual, String expected, String message) {
		log4jobject.info("Assertion starts");
		assertEquals(actual, expected);
		log4jobject.info(message);

	}

}
