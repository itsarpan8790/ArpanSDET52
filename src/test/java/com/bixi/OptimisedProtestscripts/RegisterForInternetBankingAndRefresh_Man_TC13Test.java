package com.bixi.OptimisedProtestscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.genericutility.ExcelUtility;
import com.bixi.genericutility.FileUtility;
import com.bixi.genericutility.JavaUtility;
import com.bixi.genericutility.WebDriverUtility;
import com.bixi.pom.Ebanking_Reg_FormPage;
import com.bixi.pom.HomePage;

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

		HomePage hp = new HomePage(driver);
        //Hovering to diff elements
		WebElement internetBankingButton = hp.getiBankingLink();
		wUtil.scrollDownAction(driver);
		Thread.sleep(1000);
		WebElement IBRegisterBtn = hp.getiBankingRegisterLink();
		wUtil.moveToElementAction(driver, internetBankingButton);
		wUtil.moveToElementAction(driver, IBRegisterBtn);
		wUtil.ClickAction(driver, IBRegisterBtn);

		// Reading thru Excel and entering values.
		eUtil.readMultipleDataFromExcel("ManjuTC_13", driver);
		
		//Entering Dob
		Ebanking_Reg_FormPage erfp = new Ebanking_Reg_FormPage(driver);
		WebElement DOB = erfp.getDob();
		DOB.click();
		DOB.sendKeys("01011999");

		driver.navigate().refresh();

		//validation
		
		System.out.println("Passed");// doubt
		
	}

}
