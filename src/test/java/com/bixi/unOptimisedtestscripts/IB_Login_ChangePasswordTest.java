package com.bixi.unOptimisedtestscripts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IB_Login_ChangePasswordTest {
	public static void main(String[] args) throws Throwable {

		// Step 1. Reading from Properties File
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\11thNov\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String CUSTOMERID = p.getProperty("customerId");
		String PASSWORD = p.getProperty("password");
		String NewPassword = p.getProperty("newpassword");
		System.out.println(URL);
		System.out.println(CUSTOMERID);
		System.out.println(PASSWORD);

		// Step 2. Opening Browser and Launching to Application
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		// Step 3. MouseHovering and clicking Login
		WebElement intBankinkBtn = driver.findElement(By.xpath("//a[contains(.,'Internet Banking')]"));
		WebElement intBankinkLoginBtn = driver.findElement(By.xpath("//a[.='Login ']"));

		Actions a = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		Thread.sleep(2000);
		a.moveToElement(intBankinkBtn).moveToElement(intBankinkLoginBtn).click().perform();

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
		System.out.println(67);
		String confirmationPopupText = driver.switchTo().alert().getText();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		// Step 5.Validating
		if (confirmationPopupText.contains("Success")) {
			System.out.println("Pass");
			System.out.println("Password changed Successfully and is Verified ");
		} else {
			System.out.println("Failed");
			System.out.println("Password not changed Successfully and is Verified ");

		}
		//Step 6. Logout
		driver.findElement(By.name("logout_btn")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
