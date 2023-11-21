package com.bixi.unOptimisedtestscripts;

import java.io.FileInputStream;
import java.io.IOException;
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

public class TC15_ApplyForDebitCardWithBlankFields {
	public static void main(String[] args) throws IOException, InterruptedException {
		Properties pobj = new Properties();
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\project.properties");
		pobj.load(fi);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String TITLE = pobj.getProperty("title");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\project.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1"); 
	    int count = sheet.getLastRowNum();
	    
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=1;i<=count;i++)
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
