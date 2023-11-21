package com.practise_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip_CalenderPop_Test {
	public static void main(String[] args) {
		
		
		String monthAndYear = "April 2024";
		int date = 26;
		// Step 1. Launch The browser
		WebDriver driver = new ChromeDriver();

		// Step 2.Maximize the browser
		driver.manage().window().maximize();

		// Step 3. Enter Url
		driver.get("https://www.makemytrip.com/");

		// Step 4.Pageload Wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//closing popup
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		
		//clicking departure
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
	}

}
