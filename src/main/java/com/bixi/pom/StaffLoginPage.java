package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {

	// Declaration
	@FindBy(name = "staff_id")
	private WebElement staffIdTxtBx;

	@FindBy(name = "password")
	private WebElement pwdTxtBx;

	@FindBy(xpath = "//input[@name='staff_login-btn']")
	private WebElement loginBtn;

	// Initialisation
	public StaffLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getStaffIdTxtBx() {
		return staffIdTxtBx;
	}

	public WebElement getPwdTxtBx() {
		return pwdTxtBx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	// Business Lib
	public void staffLogin(String STAFF_UN, String STAFF_PWD) {
		staffIdTxtBx.sendKeys(STAFF_UN);
		pwdTxtBx.sendKeys(STAFF_PWD);
		loginBtn.click();

	}

}
