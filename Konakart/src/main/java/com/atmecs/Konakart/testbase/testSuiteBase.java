package com.atmecs.Konakart.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.Konakart.utils.Classpaths;
import com.atmecs.Konakart.utils.ReadpropertiesFile;

/*
 * This method used to select the browser or grid and
 *  leads to work on that particular browser
 *  
 *  @author   Magesh S
*/
public class TestSuiteBase {
	Logger loggerobject = Logger.getLogger("Config files");
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();
	TestSuiteGridBase invoke = new TestSuiteGridBase();
	public static WebDriver driver;
	String getlocatorstring;
	public String browser;

	@BeforeClass
	// @Parameters("browser")
	public void browserSelect(/* String browserName */) {

		getlocatorstring = propertyobject.getLocatorValue("config.runthrough");

		if (getlocatorstring.equalsIgnoreCase("browser")) {
			String browserName = propertyobject.getLocatorValue("config.browsername");
			browser = browserName.toUpperCase();

			switch (browser) {
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
				// DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				ieCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://atmecs.com");
				driver = new InternetExplorerDriver(ieCapabilities);
				break;
			default:
				loggerobject.info("Driver name need to given correctly ");
			}
			if (driver != null) {
				loggerobject.info(browser + "  DriverInitiated");
			}

		} else if (getlocatorstring.equalsIgnoreCase("grid")) {

			invoke.gridSelect();
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(propertyobject.getLocatorValue("url.home"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void browserQuit() {
		//driver.close();
	}

}
