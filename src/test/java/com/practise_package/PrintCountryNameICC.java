package com.practise_package;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintCountryNameICC {
	public static void main(String[] args) {
		// Step 1. Launch The browser
		WebDriver driver = new ChromeDriver();

		// Step 2.Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// enter url
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String countryName = "Australia";
		WebElement ele = driver.findElement(By.xpath("//span[.='" + countryName + "']"));
		System.out.println(ele.getText());
	}

}
