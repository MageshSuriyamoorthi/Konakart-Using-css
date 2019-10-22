package com.atmecs.Konakart.reports;

import com.atmecs.Konakart.utils.Classpaths;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/*
 * This method will configure and it will get the overall report.
 * 
 * 
 * @author   Magesh.S
 */
public class ExtentReport {

	static ExtentHtmlReporter reporter = new ExtentHtmlReporter(Classpaths.extendreport + "Konakart_validation.html");
	static ExtentReports extent = new ExtentReports();

	public static void reportLog(String testname, String Failuremsg) {
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest(testname);
		logger.log(Status.INFO, testname);
		logger.log(Status.PASS, testname);
		/*
		 * logger.log(Status.FAIL, Failuremsg); logger.fail("failed script",
		 * MediaEntityBuilder.createScreenCaptureFromPath("./Openmrs/Snapshot").build())
		 * ;
		 */
		extent.flush();
	}
}


