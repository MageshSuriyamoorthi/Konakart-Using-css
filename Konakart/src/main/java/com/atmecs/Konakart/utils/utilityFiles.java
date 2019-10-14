package com.atmecs.Konakart.utils;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.Konakart.reports.log4j;
import com.atmecs.Konakart.testbase.testSuiteBase;

/*
 * This method used to perform some action on the script.
 *
 *  
 *  @author   Magesh S
*/

public class utilityFiles extends testSuiteBase {
	WebElement element;
	// By findelement=null;
	String getval;
	public static ReadpropertiesFile readpropertyobject = new ReadpropertiesFile();
	public static log4j log4jobject = new log4j();
	public static XlxsReader xlxsreaderobject = utilityFiles.getXlsReader(Classpaths.Excel_file_one);

	public String gettitle() {
		String getval = driver.getTitle();
		log4jobject.info("Got title from URL");
		return getval;
	}

	public void geturl(String string) {
		driver.get(string);
		log4jobject.info("URL opens");
	}

	public void maximize() {
		driver.manage().window().maximize();
		log4jobject.info("Browser Maximized");
	}

	public WebElement findMethod(String locatorValue) {
		String[] locators = locatorValue.split(":");
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(3, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);
		switch (locators[0].toUpperCase()) {
		case "CLASSNAME":

			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element = driver.findElement(By.className(locators[1]));
					return true;
				}
			});
			break;
		case "CSSSELECTOR":
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element = driver.findElement(By.cssSelector(locators[1]));
					return true;
				}
			});
			break;
		case "ID":
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element = driver.findElement(By.id(locators[1]));
					return true;
				}
			});

			break;
		case "LINKTEXT":

			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element = driver.findElement(By.linkText(locators[1]));
					return true;
				}
			});
			break;
		case "NAME":
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element = driver.findElement(By.name(locators[1]));
					return true;
				}
			});
			break;
		case "PARTIALLINKTEXT":
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element = driver.findElement(By.partialLinkText(locators[1]));
					return true;
				}
			});
			break;
		case "TAGNAME":
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element = driver.findElement(By.tagName(locators[1]));
					return true;
				}
			});
			break;
		case "XPATH":
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					element = driver.findElement(By.xpath(locators[1]));
					return true;
				}
			});
			break;
		default:
			log4jobject.info("Enter correct locator");
			break;
		}
		return element;
	}

	public WebElement click(String locatorValue) {
		log4jobject.info("Click is progressed");
		WebElement value = findMethod(locatorValue);
		value.click();
		log4jobject.info("click is done");
		return value;
	}

	public WebElement entertextone(String locatorValue, int text) {
		log4jobject.info("Entering text into text box");
		WebElement value = findMethod(locatorValue);
		value.sendKeys(utilityFiles.gettextdata("textbox_values", text));
		log4jobject.info(text + " is entered");
		return value;
	}

	public WebElement entertext(String locatorValue, String text) {
		log4jobject.info("Entering text into text box");
		WebElement value = findMethod(locatorValue);
		value.sendKeys(utilityFiles.gettextdataone(text));
		log4jobject.info(text + " is entered");
		return value;
	}

	public void dropdown(String locatorValue, String text) {
		log4jobject.info("Dropdown method starts to perform");
		Select value = new Select(findMethod(locatorValue));
		value.selectByVisibleText(text);
		log4jobject.info("Dropdown method done");
	}

	public void scroll() {
		log4jobject.info("Scrolls performed");
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0,650)");
		log4jobject.info("Scroll done");

	}

	public String scrolltoview(String locatorValue) {
		log4jobject.info("Scroll to view starts to perform");
		WebElement element = findMethod(locatorValue);
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].scrollIntoView();", element);
		javascript.executeScript("window.scrollTo(0,-500)");
		log4jobject.info("Scroll to view done");
		return locatorValue;

	}

	public static String getActual(String locatorValue) {
		log4jobject.info("Getting text from data");
		String[] locators = locatorValue.split(":");
		String getstring = driver.findElement(By.cssSelector(locators[1])).getText();
		return getstring;
	}

	public static List<String> getexpected(String symbol) {
		log4jobject.info("split text from testdata");
		String data = xlxsreaderobject.getCellDataByColumnName("Sheet1", "columnName", 1);
		String[] contents = data.split(symbol);
		List<String> list = new ArrayList<String>();
		for (String arr : contents)
			list.add(arr);
		log4jobject.info("splittest ends");
		return list;
	}

	public static boolean isDisplayed(String Xpath) {
		boolean isdisplayed = false;
		log4jobject.info("Verifiying isDisplay method");
		isdisplayed = driver.findElement(By.cssSelector(Xpath)).isDisplayed();
		if (isdisplayed = true) {
			log4jobject.info("isDisplay ends successfully");
			return isdisplayed;
		} else {
			log4jobject.info("isDisplay method fails");
			return false;
		}
	}

	public static XlxsReader getXlsReader(String testDataFile) {
		XlxsReader xlsReader = new XlxsReader();

		try {
			xlsReader.setPath(testDataFile);
		} catch (IOException ioException) {
			return null;
		}
		return xlsReader;
	}

	public static String expectedresult(String Xpath, int beginindex, int endindex) {
		log4jobject.info("text split action performs");
		String[] locators = Xpath.split(":");
		String name = driver.findElement(By.cssSelector(locators[1])).getText().substring(beginindex, endindex);
		return name;
	}

	public String locateexpectedvals(String Xpath) {
		log4jobject.info("Getting Text present in an element");
		String[] locators = Xpath.split(":");
		String value = driver.findElement(By.cssSelector(locators[1])).getText();
		log4jobject.info("Actual " + value);
		return value;
	}

	public String locategettext(String locator) {
		log4jobject.info("Getting Text present in an element");
		String[] locators = locator.split(":");
		String value = driver.findElement(By.cssSelector(locators[1])).getText();
		//log4jobject.info("The text is " + value);
		return value;
	}

	public boolean mouseHoverTotab(String locatorValue) {
		log4jobject.info("Performing movehover");
		WebElement webElement = findMethod(locatorValue);
		Actions action = new Actions(driver);
		action.moveToElement(webElement);
		log4jobject.info("mouse movehovered");
		return true;
	}

	public List<WebElement> getListOfWebElement(String locatorvalue) {
		log4jobject.info("Getting list performs");
		String[] locators = locatorvalue.split(":");
		List<WebElement> list = driver.findElements(By.cssSelector(locators[1]));
		log4jobject.info("got list");
		return list;
	}

	public List<String> convertListFromWebElement(List<WebElement> list) {
		log4jobject.info("Converting list performs");
		List<String> textList = new ArrayList<String>();
		if (list.size() > 0) {
			for (WebElement element : list) {
				textList.add(element.getText());
			}
		}
		log4jobject.info("List converted");
		return textList;
	}

	public String getnewlocator(String Xpath, String replacingtext, String expectedtext) {
		log4jobject.info("replacing dynamic xpathlocator");
		String replacedtext = readpropertyobject.getLocatorValue(Xpath).replace(replacingtext, expectedtext);
		log4jobject.info("Replaced dynamic locator");
		return replacedtext;

	}

	public static String gettextdata(String column_name, int text) {
		log4jobject.info("Getting testdata");
		String contents = xlxsreaderobject.getCellDataByColumnName("Sheet1", column_name, text);
		return contents;
	}

	public static String gettextdataone(String column_name) {
		log4jobject.info("Getting testdata");
		String contents = xlxsreaderobject.getCellDataByColumnName("Sheet1", column_name, 1);
		return contents;
	}

	public static String gettextdatatwo(String sheet_name, String column_name) {
		log4jobject.info("Getting testdata");
		String contents = xlxsreaderobject.getCellDataByColumnName(sheet_name, column_name, 1);
		return contents;
	}
}
