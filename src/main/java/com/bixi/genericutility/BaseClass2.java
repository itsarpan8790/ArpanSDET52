package com.bixi.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass2 {
	public WebDriver driver;
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eUtil = new ExcelUtility();

	public String BROWSER;
	public String URL;
	public String CUSTOMERID;
	public String PASSWORD;
	public String NEWPASSWORD;

	@BeforeSuite
	public void config_BS() throws Throwable {
		BROWSER = fUtil.readDataFromPropertyFile("browser");
		URL = fUtil.readDataFromPropertyFile("url");
		CUSTOMERID = fUtil.readDataFromPropertyFile("customerId");
		PASSWORD = fUtil.readDataFromPropertyFile("password");
		NEWPASSWORD = fUtil.readDataFromPropertyFile("newpassword");
	}

	@BeforeMethod
	public void config_BM() {
		// Opening Browser
		if (BROWSER.equals("chrome")) {
			//System.out.println(BROWSER);
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("Invalid browsername");

		// Maximising Browser
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 10);
		driver.get(URL);
	}

	@AfterMethod
	public void config_AM() {
		wUtil.minimizeWindow(driver);
		driver.close();
	}

}
