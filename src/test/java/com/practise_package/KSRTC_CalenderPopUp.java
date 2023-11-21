package com.practise_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTC_CalenderPopUp {
	public static void main(String[] args) throws InterruptedException {
		String month = "December";
		int date = 7;
		// Step 1. Launch The browser
		WebDriver driver = new ChromeDriver();

		// Step 2.Maximize the browser
		driver.manage().window().maximize();

		// Step 3. Enter Url
		driver.get("https://www.ksrtc.in/oprs-web/");

		// Step 4.Pageload Wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// Clicking Departure calender
		driver.findElement(By.id("txtJourneyDate")).click();
		Thread.sleep(1000);

		// Selecting Date
		for (;;) {
			try {
				driver.findElement(By.xpath("//span[text()='" + month
						+ "']/ancestor::div[@id='ui-datepicker-div']//a[text()='" + date + "']")).click();
			} catch (Exception e) {
				String arrow = "(//span[text()='Next'])[3]";
				driver.findElement(By.xpath(arrow)).click();
			}
		}

	}

}
