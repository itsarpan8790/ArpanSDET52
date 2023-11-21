package com.bixi.OptimisedProtestscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.genericutility.ExcelUtility;
import com.bixi.genericutility.FileUtility;
import com.bixi.genericutility.JavaUtility;
import com.bixi.genericutility.WebDriverUtility;
import com.bixi.pom.CustomerLoginPage;
import com.bixi.pom.Customer_Pass_ChangePage;
import com.bixi.pom.Customer_ProfilePage;
import com.bixi.pom.HomePage;

public class IB_Login_ChangePasswordTest {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		FileUtility fUtil = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();

		// Step 1. Reading from Properties File
		String URL = fUtil.readDataFromPropertyFile("url");
		String CUSTOMERID = fUtil.readDataFromPropertyFile("customerId");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		String NewPassword = fUtil.readDataFromPropertyFile("newpassword");

		// Step 2. Opening Browser and Launching to Application
		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 10);
		driver.get(URL);

		// Step 3. MouseHovering and clicking Login
		HomePage hp = new HomePage(driver);
		WebElement iBankinkLink = hp.getiBankingLink();
		WebElement iBankingLoginLink = hp.getiBankingLoginLink();
		wUtil.multipleAction(driver, iBankinkLink, iBankingLoginLink);
		wUtil.scrollUpAction(driver);
		Thread.sleep(2000);

		// User Login
		CustomerLoginPage clp = new CustomerLoginPage(driver);
		clp.loginAsCutomer(CUSTOMERID, PASSWORD);

		// Step 5.Changepassword
		Customer_ProfilePage cpp = new Customer_ProfilePage(driver);
		cpp.getChangePwdLink().click();

		Customer_Pass_ChangePage cpc = new Customer_Pass_ChangePage(driver);
		cpc.getOldPWTextBx().sendKeys(PASSWORD);
		Thread.sleep(500);
		cpc.getCnfmOldPWTextBx().sendKeys(PASSWORD);
		Thread.sleep(500);
		cpc.getNewPWTextBx().sendKeys(NewPassword);
		Thread.sleep(500);
		cpc.getSubmitBtn().click();
		String confirmationPopupText = wUtil.getAlertPopUpText(driver);
		Thread.sleep(500);
		wUtil.handleAlertPopUp(driver);

		// Step 5.Validating
		if (confirmationPopupText.contains("Success")) {
			System.out.println("Pass");
			System.out.println("Password changed Successfully and is Verified ");
		} else {
			System.out.println("Failed");
			System.out.println("Password not changed Successfully and is Verified ");

		}
		// Step 6. Logout
		cpp.getLogOutBtn().click();
		Thread.sleep(2000);
		wUtil.minimizeWindow(driver);
		driver.quit();
	}

}
