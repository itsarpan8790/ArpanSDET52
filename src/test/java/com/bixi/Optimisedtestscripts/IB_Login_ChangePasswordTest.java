package com.bixi.Optimisedtestscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.genericutility.ExcelUtility;
import com.bixi.genericutility.FileUtility;
import com.bixi.genericutility.JavaUtility;
import com.bixi.genericutility.WebDriverUtility;

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
		System.out.println(URL);
		System.out.println(CUSTOMERID);
		System.out.println(PASSWORD);

		// Step 2. Opening Browser and Launching to Application
		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 10);
		driver.get(URL);

		// Step 3. MouseHovering and clicking Login
		WebElement intBankinkBtn = driver.findElement(By.xpath("//a[contains(.,'Internet Banking')]"));
		WebElement intBankinkLoginBtn = driver.findElement(By.xpath("//a[.='Login ']"));
		wUtil.multipleAction(driver, intBankinkBtn, intBankinkLoginBtn);
		wUtil.scrollUpAction(driver);
		Thread.sleep(2000);

		// Step 4.User Login
		driver.findElement(By.name("customer_id")).sendKeys(CUSTOMERID);
		Thread.sleep(500);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login-btn")).click();

		// Step 5.Changing password
		driver.findElement(By.xpath("//li[text()='Change Password']")).click();

		driver.findElement(By.name("oldpass")).sendKeys(PASSWORD);
		Thread.sleep(500);
		driver.findElement(By.name("cnfrm")).sendKeys(PASSWORD);
		Thread.sleep(500);
		driver.findElement(By.name("newpass")).sendKeys(NewPassword);
		Thread.sleep(500);
		driver.findElement(By.name("change_pass")).click();

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
		driver.findElement(By.name("logout_btn")).click();
		Thread.sleep(2000);
		wUtil.minimizeWindow(driver);
		driver.quit();

	}

}
