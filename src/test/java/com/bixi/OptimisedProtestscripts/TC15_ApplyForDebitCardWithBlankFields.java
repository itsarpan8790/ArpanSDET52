package com.bixi.OptimisedProtestscripts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.genericutility.ExcelUtility;
import com.bixi.genericutility.FileUtility;
import com.bixi.genericutility.JavaUtility;
import com.bixi.genericutility.WebDriverUtility;
import com.bixi.pom.HomePage;

public class TC15_ApplyForDebitCardWithBlankFields {
	public static void main(String[] args) throws Throwable {
		
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
		
	    int rowCount = eUtil.getLastRowNumber("NeyazTC_15");
	    eu
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=1;i<=rowCount;i++)
		{
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Alert alertpopup = driver.switchTo().alert();
		String errormsg = alertpopup.getText();
		System.out.println("Error message displayed as: "+errormsg);
		alertpopup.accept();
		
		driver.quit();
	}

}
