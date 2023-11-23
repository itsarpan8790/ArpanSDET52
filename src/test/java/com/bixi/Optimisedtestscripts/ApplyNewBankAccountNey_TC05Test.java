package com.bixi.Optimisedtestscripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.genericutility.ExcelUtility;
import com.bixi.genericutility.FileUtility;
import com.bixi.genericutility.JavaUtility;
import com.bixi.genericutility.WebDriverUtility;

public class ApplyNewBankAccountNey_TC05Test {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		FileUtility fUtil = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();

		// Step 1. Reading from Properties File
		String URL = fUtil.readDataFromPropertyFile("url");
		System.out.println(URL);

		// Step 2. Opening Browser and Launching to Application
		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 10);
		driver.get(URL);

		// Step 3.Clicking Open Account Button
		driver.findElement(By.xpath("//ul/a/li[text()='Open Account']")).click();

		// Step 4.Entering Data
		eUtil.readMultipleDataFromExcel("NeyazTC_05", driver);

		// Step 5.Entering DOB
		Robot r = new Robot();
		driver.findElement(By.name("dob")).click();
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_4);
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_4);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_1);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_9);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_9);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_9);

		// Step 6.Selecting DropDowns
		WebElement stateDD = driver.findElement(By.name("state"));
		wUtil.dropDown(stateDD, 2);

		WebElement cityDD = driver.findElement(By.name("city"));
		wUtil.dropDown(cityDD, 2);

		WebElement accountDD = driver.findElement(By.name("acctype"));
		wUtil.dropDown(accountDD, 2);

		// Step 7.Clicking Submit
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("cnfrm-submit")).click();

		// Step 8.Handling Popup

		String confirmationMsg = wUtil.getAlertPopUpText(driver);
		Thread.sleep(2000);
		wUtil.handleAlertPopUp(driver);
		System.out.println(confirmationMsg);

		// Step 9.Validation
		if (confirmationMsg.contains("Application submitted successfully")) {
			System.out.println("Pass");
			System.out.println("Account created Successfully");
		} else {
			System.out.println("Failed");
			System.out.println("Account not created");
		}

		// Step 10.Extracting Application No
		String applicationNo = "";
		for (int i = 0; i < confirmationMsg.length(); i++) {
			if (Character.isDigit(confirmationMsg.charAt(i))) {
				applicationNo = applicationNo + confirmationMsg.charAt(i);
			}
		}
		System.out.println("Application no is :" + applicationNo);

	}

}
