package com.atmecs.Konakart.testbase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.atmecs.Konakart.utils.ReadpropertiesFile;
import com.atmecs.Konakart.utils.utilityFiles;

/*
 * This method used to select the browser or grid and
 *  leads to work on that particular browser
 *  
 *  @author   Magesh S
*/

public class testSuiteGridBase {
	URL url;
	String nodeurl, browser;
	WebDriver driver;
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();
	DesiredCapabilities capability = new DesiredCapabilities();

	public void gridSelect() {
		browser = propertyobject.getLocatorValue("config.browsername");
		String browserName = browser.toUpperCase();
		nodeurl = propertyobject.getLocatorValue("node_url");

		try {
			url = new URL(nodeurl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		switch (browserName) {
		case "CHROME":
			capability = DesiredCapabilities.chrome();
			break;
		case "FIREFOX":
			capability = DesiredCapabilities.firefox();
			break;
		case "IE":
			capability = DesiredCapabilities.internetExplorer();
			break;
		}
		capability.setBrowserName(browser);
		capability.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(url, capability);
	}
	

}
