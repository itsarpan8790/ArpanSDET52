package com.bixi.OptimisedProtestscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.genericutility.ExcelUtility;
import com.bixi.genericutility.FileUtility;
import com.bixi.genericutility.JavaUtility;
import com.bixi.genericutility.WebDriverUtility;
import com.bixi.pom.HomePage;

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

		HomePage hp = new HomePage(driver);
		WebElement internetBankingButton = hp.getiBankingLink();
		wUtil.scrollUpAction(driver);
		WebElement IBRegisterBtn = hp.getiBankingRegisterLink();
		Thread.sleep(2000);

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
