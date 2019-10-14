package com.atmecs.Konakart.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.atmecs.Konakart.utils.Classpaths;
import com.atmecs.Konakart.utils.ReadpropertiesFile;

/*
 * This method used to select the browser or grid and
 *  leads to work on that particular browser
 *  
 *  @author   Magesh S
*/
public class testSuiteBase {
	Logger loggerobject = Logger.getLogger("Config files");
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();
	testSuiteGridBase invoke = new testSuiteGridBase();
	public static WebDriver driver;
	String getlocatorstring, browser;

	
	@BeforeSuite
	public void browserSelect() {

		getlocatorstring = propertyobject.getLocatorValue("config.runthrough");
	
		if (getlocatorstring.equalsIgnoreCase("browser")) {

			browser = propertyobject.getLocatorValue("config.browsername");
			String browserName = browser.toUpperCase();
			
			switch (browserName) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", Classpaths.Chrome_file);
				driver = new ChromeDriver();
				break;
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", Classpaths.Firefox_file);
				driver = new FirefoxDriver();
				break;
			case "IE":
				System.setProperty("webdriver.edge.driver", Classpaths.IE_file);
			//	DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				ieCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://bing.com");
				driver = new InternetExplorerDriver(ieCapabilities);
				break;
			default:
				loggerobject.info("Driver name need to given correctly ");
			}
			if (driver != null) {
				loggerobject.info("DriverInitiated");
			}
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} else if (getlocatorstring.equalsIgnoreCase("grid")) {

			invoke.gridSelect();
		}
	}

	//@AfterSuite
	public void browserQuit() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}

}
