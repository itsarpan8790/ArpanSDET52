package com.practise_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibibo_CalenderPopup_Test {
	public static void main(String[] args) throws InterruptedException {
		
		String monthAndYear = "April 2024";
		int date = 26;
		// Step 1. Launch The browser
		WebDriver driver = new ChromeDriver();

		// Step 2.Maximize the browser
		driver.manage().window().maximize();

		// Step 3. Enter Url
		driver.get("https://www.goibibo.com/");

		// Step 4.Pageload Wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// Step 5. Clicking on Close Arrow
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();

		// Step 6. Clicking on Departure
		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		// Step 7. Locationg arrow
		String arrow = "//span[@aria-label='Next Month']";

		// Step 8.Selecting Date
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='" + monthAndYear
						+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + date + "']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath(arrow)).click();
			}

		}

		// Step 9.Clicking on Done
		driver.findElement(By.xpath("//span[text()='Done']")).click();

		Thread.sleep(3000);
		// Step 10. Closing Browser
		driver.quit();
	}

}
