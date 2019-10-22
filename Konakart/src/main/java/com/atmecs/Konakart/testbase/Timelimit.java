package com.atmecs.Konakart.testbase;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.Konakart.utils.ReadpropertiesFile;

public class Timelimit {

	ReadpropertiesFile property=new ReadpropertiesFile();
	Month monthObj = new Month();
	String date, differenceOfDate, getClassName, eachRatingXpath;
	String[] dateArray, actualDateList;
	int totalproduct;
	// List<WebElement>allRatings;

	public String[] sortDate(List<WebElement> allDates) {
		String listOfDayDifference[] = new String[allDates.size()];

		for (int index = 0; index < allDates.size(); index++) {
			date = allDates.get(index).getText();
			dateArray = allDates.get(index).getText().split("\\s+", 2);
			differenceOfDate = monthObj.daysdifference(dateArray[1]);
			listOfDayDifference[index] = differenceOfDate;
			// log.info("date is " + date + " difference in date is " + differenceOfDate);
		}
		// .info(Arrays.toString(listOfDayDifference));
		return listOfDayDifference;
	}
	public int[] getRating(WebDriver driver,String Property,int totalProductNumber) throws Exception {
		
		int listOfRating[]=new int[totalProductNumber];
		List<WebElement>ratingList;
		for(int indexRating=1;indexRating<=listOfRating.length;indexRating++) {
			String ratingLocator=property.getLocatorValue(Property).replace("###", indexRating+"");
			
			ratingList=driver.findElements(By.cssSelector(ratingLocator));
					/*getElementObject.getElements(driver,ratingLocator)*/
			
			listOfRating[indexRating-1]=ratingList.size()/2;
		}
		System.out.println(Arrays.toString(listOfRating)+" list of Rating");
		return listOfRating;
	}
}
