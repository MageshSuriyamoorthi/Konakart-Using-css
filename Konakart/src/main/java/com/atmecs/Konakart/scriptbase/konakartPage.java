package com.atmecs.Konakart.scriptbase;

import java.util.List;

import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.utilityFiles;
import com.atmecs.Konakart.utils.verificationManager;

public class konakartPage {
	String actual, expected;
	utilityFiles util = new utilityFiles();
	ReadpropertiesFile property = new ReadpropertiesFile();

	public void searchproduct(String dd_data, String dd_text) {

		util.dropdown(property.getLocatorValue("locator.select.dropdown"), dd_data);

		util.entertext(property.getLocatorValue("locator.entertext.field"), dd_text);

		util.click(property.getLocatorValue("locator.search.button"));

	}

	public String getTitle() {

		util.click(property.getLocatorValue("locator.hero.navigation"));

		String title = util.gettitle();

		util.scroll();

		return title;
	}

	public String actualvalidation(String locator) {
		return actual = util.locategettext(property.getLocatorValue(locator));
	}

	public String exppectedvalidation(String columnname) {
		return expected = utilityFiles.gettextdatatwo("Sheet3", columnname);
	}

}