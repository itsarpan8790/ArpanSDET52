package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_ProfilePage {
	// Declaration
	@FindBy(xpath = "//li[text()='Change Password']")
	private WebElement changePwdLink;

	@FindBy(name = "logout_btn")
	private WebElement logOutBtn;

	// Initialisation
	public Customer_ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getChangePwdLink() {
		return changePwdLink;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

}
