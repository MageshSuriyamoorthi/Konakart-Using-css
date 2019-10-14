package com.atmecs.Konakart.testscripts;

import org.testng.annotations.Test;

import com.atmecs.Konakart.scriptbase.konakartPage;
import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.utilityFiles;
import com.atmecs.Konakart.utils.verificationManager;

public class konakartHero extends konakartHome {
	konakartPage konakartheroobject = new konakartPage();
	utilityFiles util = new utilityFiles();
	ReadpropertiesFile property = new ReadpropertiesFile();
	konakartPage konakartpage = new konakartPage();

	String kitchentitle = utilityFiles.gettextdatatwo("Sheet2", "Kitchentitle");
	String kindletitle = utilityFiles.gettextdatatwo("Sheet2", "kindletitle");
	String title, actual, expected;

	@Test(priority = 1)
	public void Hero_validation() {

		title = konakartpage.getTitle();

		if (title.equals(kitchentitle)) {
			actual = konakartpage.actualvalidation("locator.kitchenproduct.validation");
			expected = konakartpage.exppectedvalidation("kitchendescription");
			verificationManager.assertmatch(actual, expected, "The kitchen product description is validated");

		} else {
			actual = konakartpage.actualvalidation("locator.kindleproduct.validation");
			expected = konakartpage.exppectedvalidation("kindledescription");
			verificationManager.assertmatch(actual, expected, "The kindle product description is validated");
		}
		
		util.click(property.getLocatorValue("locator.specification.click"));

		if (title.equals(kitchentitle)) {
			actual = konakartpage.actualvalidation("locator.kitchenspecification.validation");
			expected = konakartpage.exppectedvalidation("kitchenspecs");
			verificationManager.assertmatch(actual, expected, "The kitchen product specification is validated");

		} else {
			konakartpage.actualvalidation("locator.kindlespecification.validation");
			expected = konakartpage.exppectedvalidation("kindlespecs");
			verificationManager.assertmatch(actual, expected, "The kindle product specification is validated");
		}
		
		util.click(property.getLocatorValue("locator.customerreview.click"));
		
		if (title.equals(kitchentitle)) {
			verificationManager.assertmatch(actual, expected, "The kitchen product review is validated");

		} else {
			verificationManager.assertmatch(actual, expected, "The kindle product review is validated");
		}

		
	}
}
