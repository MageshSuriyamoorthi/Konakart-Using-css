package com.atmecs.Konakart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.Konakart.reports.log4j;
import com.atmecs.Konakart.scriptbase.konakartPage;
import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.utilityFiles;
import com.atmecs.Konakart.utils.verificationManager;

public class konakartHero extends konakartHome {
	konakartPage konakartheroobject = new konakartPage();
	utilityFiles util = new utilityFiles();
	ReadpropertiesFile property = new ReadpropertiesFile();
	konakartPage konakartpage = new konakartPage();
	public static log4j log4jobject = new log4j();

	int[] starData;

	String kitchentitle = utilityFiles.gettextdatatwo("Sheet2", "Kitchentitle");
	String kindletitle = utilityFiles.gettextdatatwo("Sheet2", "kindletitle");
	String title, actual, expected;
	
	boolean booleanactual;
	boolean booleanexpected=true;

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
			actual = konakartpage.actualvalidation("locator.kindlespecification.validation");
			expected = konakartpage.exppectedvalidation("kindlespecs");

			verificationManager.assertmatch(actual, expected, "The kindle product specification is validated");
		}

		util.click(property.getLocatorValue("locator.customerreview.click"));

		konakartpage.datevalidation("newest first", "locator.customerreview.getdate");

		util.dropdown(property.getLocatorValue("locator.customerreview.dropdown"), "Oldest first");

		konakartpage.datevalidation("oldest first", "locator.customerreview.getdate");

		util.dropdown(property.getLocatorValue("locator.customerreview.dropdown"), "Rating: high to low");

		starData = konakartpage.starvalidate("locator.customerreview.staarvalue");

		booleanactual=konakartpage.Ascending(starData);
		
		Assert.assertEquals(booleanactual, booleanexpected);
		
		log4jobject.info("asserted");

		util.dropdown(property.getLocatorValue("locator.customerreview.dropdown"), "Rating: low to high");

		starData = konakartpage.starvalidate("locator.customerreview.staarvalue");

		booleanactual=konakartpage.Descending(starData);
		
		Assert.assertEquals(booleanactual, booleanexpected);

		log4jobject.info("asserted");


	}
}
