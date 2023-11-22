package com.bixi.BaseTestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.genericutility.ExcelUtility;
import com.bixi.genericutility.FileUtility;
import com.bixi.genericutility.JavaUtility;
import com.bixi.genericutility.WebDriverUtility;
import com.bixi.pom.Debit_Card_FormPage;
import com.bixi.pom.HomePage;

public class DebitCardTest {

	public void applyForDebitCardWithBlankFields_NeyazTC15() throws Throwable {
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		FileUtility fUtil = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();

		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");

		WebDriver driver = new ChromeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 10);
		driver.get(URL);

		HomePage hp = new HomePage(driver);
		hp.getApplyDebitCardLink().click();

		eUtil.readMultipleDataFromExcel("NeyazTC_15", driver);

		Thread.sleep(2000);
		Debit_Card_FormPage dcf = new Debit_Card_FormPage(driver);
		dcf.getSubmitBtn().click();

		String errormsg = wUtil.getAlertPopUpText(driver);
		System.out.println("Error message displayed as: " + errormsg);
		Thread.sleep(5000);
		wUtil.handleAlertPopUp(driver);

		Thread.sleep(2000);
		driver.quit();
	}
}
