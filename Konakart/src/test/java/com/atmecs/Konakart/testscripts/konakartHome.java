package com.atmecs.Konakart.testscripts;

import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.Konakart.scriptbase.konakartPage;
import com.atmecs.Konakart.testbase.testSuiteBase;
import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.utilityFiles;
import com.atmecs.Konakart.utils.verificationManager;

public class konakartHome extends testSuiteBase {
	utilityFiles util = new utilityFiles();
	ReadpropertiesFile property = new ReadpropertiesFile();
	konakartPage konakartpage = new konakartPage();
	String actual, expected;

	@BeforeMethod
	public void open_url() {
		util.geturl(property.getLocatorValue("url.home"));
		util.maximize();
	}

	@Test(priority = 0)
	public void homepage_Search() {
		konakartpage.searchproduct(utilityFiles.gettextdataone("dropdown_data"), "positive value");

		expected = utilityFiles.getActual(property.getLocatorValue("locator.product.available"));

		actual = utilityFiles.getActual(property.getLocatorValue("locator.product.text"));

		verificationManager.assertequals(actual, expected, "the product were equal");

		konakartpage.searchproduct(utilityFiles.gettextdataone("dropdown_data"), "negative value");

		actual = utilityFiles.getActual(property.getLocatorValue("locator.product.validate"));

		verificationManager.assertequals(actual, utilityFiles.gettextdataone("negativevalues"),"There is no such products try, different search");

		konakartpage.searchproduct(utilityFiles.gettextdataone("dropdown_data"), "neutral value");

		actual = utilityFiles.getActual(property.getLocatorValue("locator.product.validate"));

		List<String> needed = verificationManager.Splittext("for", actual);

		verificationManager.assertequals(needed.get(0), utilityFiles.gettextdataone("neutralvalues"),
				"There is no such products try, different search");
	}
}
