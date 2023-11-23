package com.bixi.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * @author arpan
	 * This Method will maximize the Window
	 * 
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();

	}

	/**
	 * This Method will minimize the Window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This Method will wait for 10 Seconds for the Web Page to get Loaded
	 * 
	 * @param Driver
	 */
	public void implicitWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	/**
	 * This Method will Wait for 10 Seconds for the Elements to be Visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This Method will Wait for 10 Seconds for the Elements to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will handle dropdown by Index.
	 * 
	 * @param element
	 * @param index
	 */
	public void dropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This methiod will handle dropdown by Value.
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This methiod will handle dropdown by Visible Text.
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void moveToElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	public void contextClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void contextClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	

	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();

	}

	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();

	}
	
	public void multipleAction(WebDriver driver,WebElement ele1,WebElement ele2) {
		Actions act = new Actions(driver);
		act.moveToElement(ele1).moveToElement(ele2).click().perform();

	}
	
	

	public void sendKeysAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();

	}

	public void sendKeysAction(WebDriver driver, WebElement element, CharSequence text) {
		Actions act = new Actions(driver);
		act.sendKeys(element, text).perform();

	}

	public void ClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();

	}

	public void keyPressEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);

	}

	public void keyReleaseEnter() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public void keyPressT() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);

	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void handleAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String getAlertPopUpText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void switchToWindow(WebDriver driver, String expPartialTitle) {
		// Capture all Window Ids
		Set<String> allwId = driver.getWindowHandles();

		// Navigate to all Window Ids
		for (String wId : allwId) {
			// Switch to each wid and capture Title
			String actualTitle = driver.switchTo().window(wId).getTitle();
			// compare actual title with expected partial Title.
			if (actualTitle.equals(expPartialTitle)) {
				break;
			}
		}
	}

	/**
	 * This Method will Scroll Up for 500 Units
	 * 
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
	}

	/**
	 * This Method will Scroll Down for 500 Units
	 * 
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	/**
	 * This Method will Scroll Right for 500 Units
	 * 
	 * @param driver
	 */
	public void scrollRightAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0)", "");
	}

	/**
	 * This Method will Scroll Left for 500 Units
	 * 
	 * @param driver
	 */
	public void scrollLeftAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-500,0)", "");
	}



	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true);", element);
	}
	
	public static String takeScreenshot(WebDriver sdriver,String SSNAME) {
		TakesScreenshot ts=(TakesScreenshot) sdriver;
		String path="./Screenshots/"+SSNAME+".png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			 
		}
		return path;
		
		
	}

}
