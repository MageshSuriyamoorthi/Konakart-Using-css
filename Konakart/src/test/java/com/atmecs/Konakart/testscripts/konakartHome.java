package com.atmecs.Konakart.testscripts;

import java.util.List;

import org.testng.annotations.Test;

import com.atmecs.Konakart.scriptbase.KonakartPage;
import com.atmecs.Konakart.testbase.TestSuiteBase;
import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.UtilityFiles;
import com.atmecs.Konakart.utils.VerificationManager;
/*
 * This method is the script of the first scenario. 
 *
 *  
 *  @author   Magesh S
*/

public class KonakartHome extends TestSuiteBase {
	UtilityFiles util = new UtilityFiles();
	TestSuiteBase test = new TestSuiteBase();
	ReadpropertiesFile property = new ReadpropertiesFile();
	KonakartPage konakartpage = new KonakartPage();
	String actual, expected;

	@Test
	public void homepage_Search() {

		konakartpage.searchproduct(UtilityFiles.gettextdataone("dropdown_data"), "positive value");

		expected = UtilityFiles.getActual(property.getLocatorValue("locator.product.available"));

		actual = UtilityFiles.getActual(property.getLocatorValue("locator.product.text"));

		VerificationManager.assertequals(actual, expected, "the product were equal");

		konakartpage.searchproduct(UtilityFiles.gettextdataone("dropdown_data"), "negative value");

		actual = UtilityFiles.getActual(property.getLocatorValue("locator.product.validate"));

		VerificationManager.assertequals(actual, UtilityFiles.gettextdataone("negativevalues"),
				"There is no such products try, different search");

		konakartpage.searchproduct(UtilityFiles.gettextdataone("dropdown_data"), "neutral value");

		actual = UtilityFiles.getActual(property.getLocatorValue("locator.product.validate"));

		List<String> needed = VerificationManager.Splittext("for", actual);

		VerificationManager.assertequals(needed.get(0), UtilityFiles.gettextdataone("neutralvalues"),
				"There is no such products try, different search");
	}

}
