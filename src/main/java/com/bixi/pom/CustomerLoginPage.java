package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {
	// Declaration
	@FindBy(name = "customer_id")
	private WebElement custIdTextBx;

	@FindBy(name = "password")
	private WebElement passwordTextBx;

	@FindBy(name = "login-btn")
	private WebElement loginBtn;

	// Initialisation
	public CustomerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustIdTextBx() {
		return custIdTextBx;
	}

	public WebElement getPasswordTextBx() {
		return passwordTextBx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	// Business Logic
	public void loginAsCutomer(String UN, String PW) {
		custIdTextBx.sendKeys(UN);
		passwordTextBx.sendKeys(PW);
		loginBtn.click();

	}
	
//	public void loginAsCutomer2(String UN, String PW) {
//		custIdTextBx.sendKeys(UN);
//		passwordTextBx.sendKeys(PW);
//		loginBtn.click();
//
//	}

}
