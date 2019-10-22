package com.atmecs.Konakart.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demo {
	WebDriver driver = new ChromeDriver();

	@Test
	public void demoone() throws InterruptedException {
		driver.get("https://www.yatra.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='BE_flight_origin_date']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.cssSelector(".pg-indicators>div:nth-child(1)")).getText();
		System.out.println(text + " " + "by using get text method");

		String attribute = driver.findElement(By.cssSelector(".pg-indicators>div:nth-child(1)"))
				.getAttribute("innerText");
		System.out.println(attribute + " " + "by using attribute");

		JavascriptExecutor execute = (JavascriptExecutor) driver;
		Object tex = execute.executeScript("return document.querySelector('.indicator').innerText;").toString();

		System.out.println(tex);
	}
}