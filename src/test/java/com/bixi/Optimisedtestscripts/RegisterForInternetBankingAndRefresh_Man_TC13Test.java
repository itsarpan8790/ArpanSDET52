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

public class RegisterForInternetBankingAndRefresh_Man_TC13Test {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		FileUtility fUtil = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();

		// Step 1. Reading from Properties File
		String URL = fUtil.readDataFromPropertyFile("url");

		// Step 2. Opening Browser and Launching to Application
		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 10);
		driver.get(URL);

		WebElement internetBankingButton = driver.findElement(By.xpath("//a[contains(.,'Internet Banking')]"));
		wUtil.scrollDownAction(driver);
		Thread.sleep(1000);
		WebElement IBRegisterBtn = driver.findElement(By.xpath("//li[text()='Register']"));
		wUtil.moveToElementAction(driver, internetBankingButton);
		wUtil.moveToElementAction(driver, IBRegisterBtn);
		wUtil.ClickAction(driver, IBRegisterBtn);

		// Entering Data
		eUtil.readMultipleDataFromExcel("ManjuTC_13", driver);

		WebElement DOB = driver.findElement(By.name("dob"));
		DOB.click();
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_1);
		rbt.keyPress(KeyEvent.VK_7);
		rbt.keyPress(KeyEvent.VK_0);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_1);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_1);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_9);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_9);
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_9);
		Thread.sleep(500);

		driver.navigate().refresh();

		System.out.println("Passed");
	}

}
