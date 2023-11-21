package com.bixi.Optimisedtestscripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.bixi.genericutility.ExcelUtility;
import com.bixi.genericutility.FileUtility;
import com.bixi.genericutility.JavaUtility;
import com.bixi.genericutility.WebDriverUtility;

public class RegisterForIBAnotherTab_ManTC12Test {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		FileUtility fUtil = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();

		String Url = fUtil.readDataFromPropertyFile("url");

		// Opening Browser and Launching Application
		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 10);
		driver.get(Url);

		WebElement internetBankingButton = driver.findElement(By.xpath("//a[contains(.,'Internet Banking')]"));
		wUtil.scrollUpAction(driver);
		WebElement IBRegisterBtn = driver.findElement(By.xpath("//li[text()='Register']"));
		Thread.sleep(2000);

		// Getting parent window Title
		String parTitle = driver.getTitle();

		wUtil.moveToElementAction(driver, internetBankingButton);
		wUtil.moveToElementAction(driver, IBRegisterBtn);
		wUtil.contextClickAction(driver);
		wUtil.keyPressT();

		// Switching child popup
		wUtil.switchToWindow(driver, "ebanking_reg_form");
		// Validation
		String expTitle = "Internet Banking Registration";
		String actTitle = driver.getTitle();
		if (actTitle.equals(expTitle))
			System.out.println("Internet Banking Registration Page is Displayed");

	}

}
