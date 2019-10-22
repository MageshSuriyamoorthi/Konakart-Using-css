package com.atmecs.Konakart.testscripts;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.atmecs.Konakart.reports.Log4j;
import com.atmecs.Konakart.scriptbase.KonakartPage;
import com.atmecs.Konakart.testbase.TestSuiteBase;
import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.UtilityFiles;
import com.atmecs.Konakart.utils.VerificationManager;

/*
*This is the script of the second scenario  
*
*
*@author    Magesh S
*/
public class KonakartHero extends TestSuiteBase {
	KonakartPage konakartheroobject = new KonakartPage();
	KonakartPage konakartpage = new KonakartPage();
	public static Log4j log4jobject = new Log4j();
	UtilityFiles util = new UtilityFiles();
	ReadpropertiesFile property = new ReadpropertiesFile();

	int[] starData;

	String kitchentitle = UtilityFiles.gettextdatatwo("Sheet2", "Kitchentitle");
	String kindletitle = UtilityFiles.gettextdatatwo("Sheet2", "kindletitle");
	String title, actual, expected;

	boolean booleanactual;
	boolean booleanexpected = true;

	@Test
	public void hero_validation() {

		title = konakartpage.getTitle();

		if (title.equals(kitchentitle)) {
			actual = konakartpage.actualvalidation("locator.kitchenproduct.validation");
			expected = konakartpage.exppectedvalidation("kitchendescription");

			VerificationManager.assertmatch(actual, expected, "The kitchen product description is validated");

		} else {
			actual = konakartpage.actualvalidation("locator.kindleproduct.validation");
			expected = konakartpage.exppectedvalidation("kindledescription");

			VerificationManager.assertmatch(actual, expected, "The kindle product description is validated");
		}
		util.click(property.getLocatorValue("locator.specification.click"));

		if (title.equals(kitchentitle)) {
			actual = konakartpage.actualvalidation("locator.kitchenspecification.validation");
			expected = konakartpage.exppectedvalidation("kitchenspecs");

			VerificationManager.assertmatch(actual, expected, "The kitchen product specification is validated");

		} else {
			actual = konakartpage.actualvalidation("locator.kindlespecification.validation");
			expected = konakartpage.exppectedvalidation("kindlespecs");

			VerificationManager.assertmatch(actual, expected, "The kindle product specification is validated");
		}

		util.click(property.getLocatorValue("locator.customerreview.click"));

		konakartpage.datevalidation("newest first", "locator.customerreview.getdate");
		util.dropdown(property.getLocatorValue("locator.customerreview.dropdown"), "Oldest first");
		util.scroll();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		konakartpage.datevalidation("oldest first", "locator.customerreview.getdate");

		util.dropdown(property.getLocatorValue("locator.customerreview.dropdown"), "Rating: high to low");
		util.scroll();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		starData = konakartpage.starvalidate("locator.customerreview.starvalue");
		System.out.println(Arrays.toString(starData));
		booleanactual = konakartpage.Descending(starData);

		Assert.assertEquals(booleanactual, booleanexpected, "assert not equals");
		log4jobject.info("asserted");

		util.dropdown(property.getLocatorValue("locator.customerreview.dropdown"), "Rating: low to high");
		util.scroll();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		starData = konakartpage.starvalidate("locator.customerreview.starvalue");
		System.out.println(Arrays.toString(starData));
		booleanactual = konakartpage.Ascending(starData);

		Assert.assertEquals(booleanactual, booleanexpected, "assert not equals");
		log4jobject.info("asserted");

	}

	@AfterTest
	public void report_generation() {
		log4jobject.info("Done browser needs to close");
		// extentReport.reportLog("Konakart website", "validation Report");
	}
}
