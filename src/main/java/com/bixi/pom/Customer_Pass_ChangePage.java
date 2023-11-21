package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_Pass_ChangePage {
	//Declaration
	@FindBy(name = "oldpass")
	private WebElement oldPWTextBx;
	
	@FindBy(name = "cnfrm")
	private WebElement cnfmOldPWTextBx;
	
	@FindBy(name = "newpass")
	private WebElement newPWTextBx;
	
	@FindBy(name = "change_pass")
	private WebElement submitBtn;

	// Initialisation
	public Customer_Pass_ChangePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOldPWTextBx() {
		return oldPWTextBx;
	}

	public WebElement getCnfmOldPWTextBx() {
		return cnfmOldPWTextBx;
	}

	public WebElement getNewPWTextBx() {
		return newPWTextBx;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

}
