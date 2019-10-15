package com.atmecs.Konakart.scriptbase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.utilityFiles;
import com.atmecs.Konakart.utils.verificationManager;

public class konakartPage {
	String actual, expected;
	String title;
	String kitchentitle = utilityFiles.gettextdatatwo("Sheet2", "Kitchentitle");
	String kindletitle = utilityFiles.gettextdatatwo("Sheet2", "kindletitle");

	utilityFiles util = new utilityFiles();
	ReadpropertiesFile property = new ReadpropertiesFile();

	public void searchproduct(String dd_data, String dd_text) {

		util.dropdown(property.getLocatorValue("locator.select.dropdown"), dd_data);

		util.entertext(property.getLocatorValue("locator.entertext.field"), dd_text);

		util.click(property.getLocatorValue("locator.search.button"));

	}

	public String getTitle() {

		util.click(property.getLocatorValue("locator.hero.navigation"));

		title = util.gettitle();

		util.scroll();

		return title;
	}

	public String actualvalidation(String locator) {
		return actual = util.locategettext(property.getLocatorValue(locator));
	}

	public String exppectedvalidation(String columnname) {
		return expected = utilityFiles.gettextdatatwo("Sheet3", columnname);
	}

	public void datevalidation(String colname, String locator) {

		List<WebElement> list = util.getListOfWebElement(property.getLocatorValue("locator.customerreview.getalldate"));

		if (title.equals(kitchentitle)) {
			String columnname = colname + " for kitchen";
			for (int integer = 1; integer <= list.size(); integer++) {
				expected = utilityFiles.dynamictextreader("dateval", columnname, integer);
				actual = util.replaceforgettext(property.getLocatorValue(locator), integer + "");

				verificationManager.assertequals(actual, expected, "The kitchen " + colname + " is verified");
			}
		} else if (title.equals(kindletitle)) {
			for (int integer = 1; integer <= list.size(); integer++) {
				String columnname = colname + " for kindle";
				expected = utilityFiles.dynamictextreader("dateval", columnname, integer);
				actual = util.replaceforgettext(property.getLocatorValue(locator), integer + "");

				verificationManager.assertequals(actual, expected, "The kindle " + colname + " is verified");
			}
		}
	}

	public int[] starvalidate(String locator) {
		List<WebElement> list = util
				.getListOfWebElement(property.getLocatorValue("locator.customerreview.starratings"));
		int totalStar[] = new int[list.size()];
		for (int integer = 1; integer <= list.size(); integer++) {
			String StarVariables = property.getLocatorValue(locator).replace("**",
					integer + "");
			List<WebElement> listTwo = util.getlistoffindElements(StarVariables);
			totalStar[integer - 1] = listTwo.size();
		}
		return totalStar;
	}
	public  boolean Descending(final int[] data) {
		   for(int Arrindex = 1; Arrindex < data.length; Arrindex++) {
		       if(data[Arrindex-1] < data[Arrindex]) {
		           return false;
		       }
		   }
		   return true;
		}
		public  boolean Ascending(final int[] data) {
		   for(int Arrindex = 1; Arrindex < data.length; Arrindex++) {
		       if(data[Arrindex-1] > data[Arrindex]) {
		           return false;
		       }
		   }
		   return true;
		}
}
