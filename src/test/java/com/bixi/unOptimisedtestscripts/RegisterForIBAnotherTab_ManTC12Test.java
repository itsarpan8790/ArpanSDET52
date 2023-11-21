package com.bixi.unOptimisedtestscripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RegisterForIBAnotherTab_ManTC12Test {
	public static void main(String[] args) throws IOException, Exception {
		FileInputStream fisP = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fisP);
		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(Url);

		WebElement internetBankingButton = driver.findElement(By.xpath("//a[contains(.,'Internet Banking')]"));
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		WebElement IBRegisterBtn = driver.findElement(By.xpath("//li[text()='Register']"));

		Thread.sleep(2000);
		String parTitle = driver.getTitle();
		act.moveToElement(internetBankingButton).moveToElement(IBRegisterBtn).contextClick(IBRegisterBtn).perform();
		Thread.sleep(2000);
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_T);

		Set<String> allWinId = driver.getWindowHandles();
		for (String winId : allWinId) {
			String currTitle = driver.switchTo().window(winId).getTitle();

			if (!currTitle.equals(parTitle))
				break;
		}
		String expTitle = "Internet Banking Registration";
		String actTitle = driver.getTitle();

		if (actTitle.equals(expTitle)) {
			System.out.println("Passed");
			System.out.println("Internet Banking Registration page opened in new tab");
		}
	}

}
