package com.atmecs.Konakart.scriptbase;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.atmecs.Konakart.reports.Log4j;
import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.UtilityFiles;
import com.atmecs.Konakart.utils.VerificationManager;
/*
 * This is the base class of the script which is used to perform some 
 * sub tasks.
 *
 *  
 *  @author   Magesh S
*/

public class KonakartPage {
	String actual, expected;
	String title;
	String kitchentitle = UtilityFiles.gettextdatatwo("Sheet2", "Kitchentitle");
	String kindletitle = UtilityFiles.gettextdatatwo("Sheet2", "kindletitle");

	UtilityFiles util = new UtilityFiles();
	ReadpropertiesFile property = new ReadpropertiesFile();
	Log4j log = new Log4j();

	public void searchproduct(String dd_data, String dd_text) {
		util.dropdown(property.getLocatorValue("locator.select.dropdown"), dd_data);
		util.entertext(property.getLocatorValue("locator.entertext.field"), dd_text);
		util.click(property.getLocatorValue("locator.search.button"));
	}

	public String getTitle() {
		util.click(property.getLocatorValue("locator.hero.navigation"));
		try {
			title = util.gettitle();
		} catch (Exception exception) {
			log.info(exception + "arose");
		}
		util.scroll();
		return title;
	}

	public String actualvalidation(String locator) {
		try {
			actual = util.locategettext(property.getLocatorValue(locator));
		} catch (Exception exception) {
			log.info(exception + " found");
		}
		return actual;
	}

	public String exppectedvalidation(String columnname) {
		try {
			expected = UtilityFiles.gettextdatatwo("Sheet3", columnname);
		} catch (Exception exception) {
			log.info(exception + " found");
		}
		return expected;
	}

	public void datevalidation(String colname, String locator) {

		List<WebElement> list = util.getListOfWebElement(property.getLocatorValue("locator.customerreview.getalldate"));

		if (title.equals(kitchentitle)) {
			String columnname = colname + " for kitchen";
			log.info(columnname);
			for (int integer = 1; integer <= list.size(); integer++) {
				expected = UtilityFiles.dynamictextreader("dateval", columnname, integer);
				actual = util.replaceforgettext(property.getLocatorValue(locator), integer + "");

				VerificationManager.assertequals(actual, expected, "The kitchen " + colname + " is verified");
			}
		} else if (title.equals(kindletitle)) {
			for (int integer = 1; integer <= list.size(); integer++) {
				String columnname = colname + " for kindle";
				log.info(columnname);
				expected = UtilityFiles.dynamictextreader("dateval", columnname, integer);
				actual = util.replaceforgettext(property.getLocatorValue(locator), integer + "");

				VerificationManager.assertequals(actual, expected, "The kindle " + colname + " is verified");
			}
		}
	}

	public int[] starvalidate(String locator) {
		List<WebElement> list = util
				.getListOfWebElement(property.getLocatorValue("locator.customerreview.starratings"));
		int totalStar[] = new int[list.size()];
		for (int integer = 1; integer <= list.size(); integer++) {
			String StarVariables = property.getLocatorValue(locator).replace("**", integer + "");
			List<WebElement> listTwo = util.getlistoffindElements(StarVariables);
			totalStar[integer - 1] = listTwo.size();
		}
		return totalStar;
	}

	public boolean Descending(final int[] data) {
		for (int Arrindex = 1; Arrindex < data.length; Arrindex++) {
			if (data[Arrindex - 1] < data[Arrindex]) {
				return false;
			}
		}
		return true;
	}

	public boolean Ascending(final int[] data) {
		for (int Arrindex = 1; Arrindex < data.length; Arrindex++) {
			if (data[Arrindex - 1] > data[Arrindex]) {
				return false;
			}
		}
		return true;
	}
}
