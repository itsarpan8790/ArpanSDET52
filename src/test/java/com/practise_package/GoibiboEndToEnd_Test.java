package com.practise_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboEndToEnd_Test {
	public static void main(String[] args) {
		String monthAndYear = "April 2024";
		int date = 26;
		String dest = "Bengaluru";
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

		// Step 6.Entering Source
		driver.findElement(By.xpath("//span[text()='From']/following-sibling::p[text()='Enter city or airport']"))
				.click();
		driver.findElement(By.xpath("//div[@class='sc-12foipm-38 dAUhfz']/input")).sendKeys(dest);
		//driver.findElement(By.xpath("//div[@class='sc-12foipm-37 ehNGsE']//p[contains(.,'Patna')]")).click();
		System.out.println("36");
		List<WebElement> allsug = driver.findElements(By.xpath("//span[@class='autoCompleteTitle ']"));
		System.out.println("38");
		for (WebElement sugg : allsug) {
			System.out.println(sugg.getText());
//			if (sugg.getText().contains(dest))
//				sugg.click();
		}

	}

}
