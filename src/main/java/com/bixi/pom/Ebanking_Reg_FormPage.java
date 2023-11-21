package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebanking_Reg_FormPage {

	// Declaration
	@FindBy(name = "dob")
	private WebElement dob;

	@FindBy(name = "holder_name")
	private WebElement accHolderNameTxtBx;

	@FindBy(name = "accnum")
	private WebElement accNumTextBx;

	@FindBy(name = "dbtcard")
	private WebElement dbtNumTxtBx;

	@FindBy(name = "dbtpin")
	private WebElement dbtPinTxtBx;

	@FindBy(name = "mobile")
	private WebElement mobNoTxtBx;

	@FindBy(name = "pan_no")
	private WebElement panNumTxtBx;

	@FindBy(name = "last_trans")
	private WebElement lastTransTxtBx;

	// Initialisation
	public Ebanking_Reg_FormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getAccHolderNameTxtBx() {
		return accHolderNameTxtBx;
	}

	public WebElement getAccNumTextBx() {
		return accNumTextBx;
	}

	public WebElement getDbtNumTxtBx() {
		return dbtNumTxtBx;
	}

	public WebElement getDbtPinTxtBx() {
		return dbtPinTxtBx;
	}

	public WebElement getMobNoTxtBx() {
		return mobNoTxtBx;
	}

	public WebElement getPanNumTxtBx() {
		return panNumTxtBx;
	}

	public WebElement getLastTransTxtBx() {
		return lastTransTxtBx;
	}
	

}
