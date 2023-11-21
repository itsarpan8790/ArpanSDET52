package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_RegForm_ConfirmPage {
	// Declaration
	@FindBy(name = "cnfrm-submit")
	private WebElement confirmBtn;

	@FindBy(xpath = "//input[@value='Go back']")
	private WebElement goBackBtn;

	// Initialisation
	public Customer_RegForm_ConfirmPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}

	public WebElement getGoBackBtn() {
		return goBackBtn;
	}

}
