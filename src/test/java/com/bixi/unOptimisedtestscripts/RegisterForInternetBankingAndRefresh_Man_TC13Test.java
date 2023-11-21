package com.bixi.unOptimisedtestscripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class RegisterForInternetBankingAndRefresh_Man_TC13Test {
	public static void main(String[] args) throws Throwable {
		// Step 1. Reading from Properties File
				FileInputStream fisP = new FileInputStream(".\\src\\test\\resources\\bixidata\\commondata.properties");
				Properties p = new Properties();
				p.load(fisP);
				String URL = p.getProperty("url");

				// Step 2. Opening Browser and Launching to Application
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(URL);
				
				WebElement internetBankingButton = driver.findElement(By.xpath("//a[contains(.,'Internet Banking')]"));
				Actions a = new Actions(driver);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,500)");
				Thread.sleep(1000);
				WebElement IBRegisterBtn = driver.findElement(By.xpath("//li[text()='Register']"));
				a.moveToElement(internetBankingButton).pause(500).moveToElement(IBRegisterBtn).click(IBRegisterBtn).perform();
				
				FileInputStream fisE = new FileInputStream(".\\src\\test\\resources\\bixidata\\bixitestdata.xlsx");
				Workbook wb = WorkbookFactory.create(fisE);
				Sheet sh = wb.getSheet("ManjuTC_13");
				int rowCount = sh.getLastRowNum();
				
				HashMap<String, String> hm = new HashMap<String, String>();
				
				for (int i = 0; i <= rowCount; i++) {
					String key = sh.getRow(i).getCell(0).getStringCellValue();
					String value = sh.getRow(i).getCell(1).getStringCellValue();
					hm.put(key, value);
				}

				for (Entry<String, String> set:hm.entrySet()) {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
					Thread.sleep(500);
				}

				WebElement DOB = driver.findElement(By.name("dob"));
				DOB.click();
				Robot rbt = new Robot();
				rbt.keyPress(KeyEvent.VK_1);
				rbt.keyPress(KeyEvent.VK_7);
				rbt.keyPress(KeyEvent.VK_0);
			    Thread.sleep(500);
				rbt.keyPress(KeyEvent.VK_1);
				Thread.sleep(500);
				rbt.keyPress(KeyEvent.VK_1);
				Thread.sleep(500);
				rbt.keyPress(KeyEvent.VK_9);
				Thread.sleep(500);
				rbt.keyPress(KeyEvent.VK_9);
			    Thread.sleep(500);
				rbt.keyPress(KeyEvent.VK_9);
				Thread.sleep(500);
				
			    driver.navigate().refresh();
			    
			    System.out.println("Passed");
	}

}
