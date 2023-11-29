package com.bixi.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eUtil = new ExcelUtility();

	public String CUSTOMERID;
	public String PASSWORD;
	public String NEWPASSWORD;

	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable {

//		CUSTOMERID = fUtil.readDataFromPropertyFile("customerId");
//		PASSWORD = fUtil.readDataFromPropertyFile("password");
//		NEWPASSWORD = fUtil.readDataFromPropertyFile("newpassword");
		CUSTOMERID = eUtil.readDataFromExcelFile("NeyazUTC_05", 0, 8);
		PASSWORD = eUtil.readDataFromExcelFile("NeyazUTC_05", 1, 8);
		NEWPASSWORD = eUtil.readDataFromExcelFile("NeyazUTC_05", 2, 8);
	}
//@Parameters("gateway")
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable {
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		// Opening Browser
		if (BROWSER.equals("chrome")) {
			// System.out.println(BROWSER);
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("Invalid browsername");
		sdriver = driver;
		// Maximising Browser
		wUtil.maximizeWindow(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable {
		wUtil.implicitWait(driver, 10);
		String URL = fUtil.readDataFromPropertyFile("url");
		driver.get(URL);
	}

	@AfterClass(alwaysRun = true)
	public void config_AM() {
		wUtil.minimizeWindow(driver);
		driver.close();
	}

}
