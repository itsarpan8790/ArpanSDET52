package com.practise_package;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MockSwitchTo {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.linkText("Open New Seperate Windows")).click();
		driver.findElement(By.xpath("//button[text()='click']")).click();
		MockSwitchTo.switchToWindow(driver, "Selenium");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//a[@class='selenium-button selenium-webdriver text-uppercase fw-bold']"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].click();",ele);
//		wait.until(ExpectedConditions.elementToBeClickable(ele));
//		ele.click();
		String text = driver.getTitle();
		int price = Integer.parseInt(text);
	}

	public static void switchToWindow(WebDriver driver, String expPartialTitle) {

		Set<String> allwId = driver.getWindowHandles();

		for (String wId : allwId) {

			String actualTitle = driver.switchTo().window(wId).getTitle();

			if (actualTitle.contains(expPartialTitle)) {
				break;
			}
		}
	}
}
