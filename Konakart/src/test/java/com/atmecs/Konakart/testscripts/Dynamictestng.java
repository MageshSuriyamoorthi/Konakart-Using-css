package com.atmecs.Konakart.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.beust.testng.TestNG;
@Test
public class Dynamictestng {

	public void suite_test() {
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Suite");
		XmlTest xmlTest=new XmlTest(xmlSuite);
		xmlTest.setName("Test");
		xmlTest.setThreadCount(5);
		XmlClass publicTestClass=new XmlClass(KonakartHero.class);
		List<XmlClass> list=new ArrayList<XmlClass>();
		list.add(publicTestClass);
		xmlTest.setXmlClasses(list);
		TestNG testng=new TestNG();
		List<XmlSuite> suites=new ArrayList<XmlSuite>();
		suites.add(xmlSuite);
		testng.setXmlSuites(suites);
		testng.run();	
	}
}

