package com.practise_package;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CountrynamePresence_Test {
	public static void main(String[] args) {

		// Step 1. Launch The browser
		WebDriver driver = new ChromeDriver();

		// Step 2.Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// enter url
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String countryName = "usa";

		List<WebElement> countryEles = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));

		boolean flag = false;

		for (WebElement country : countryEles) {

			String countryText = country.getText();
			if (countryText.equals(countryName)) {
				flag = true;
				break;
			}

		}
		if (!flag)
			System.out.println("Not present");
	}

}
