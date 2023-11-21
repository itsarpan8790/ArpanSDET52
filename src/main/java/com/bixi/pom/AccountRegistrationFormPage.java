package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationFormPage {
	// Declaration
	@FindBy(name = "name")
	private WebElement nameTextBx;

	@FindBy(name = "gender")
	private WebElement genderDD;

	@FindBy(name = "mobile")
	private WebElement mobTextBx;

	@FindBy(name = "email")
	private WebElement emailTextBx;

	@FindBy(name = "landline")
	private WebElement landLineTextBx;

	@FindBy(name = "dob")
	private WebElement dobTextBx;

	@FindBy(name = "pan_no")
	private WebElement panTextBx;

	@FindBy(name = "citizenship")
	private WebElement citizenTextBx;

	@FindBy(name = "homeaddrs")
	private WebElement homeAddTextBx;

	@FindBy(name = "officeaddrs")
	private WebElement officeAddTextBx;

	@FindBy(name = "state")
	private WebElement stateDD;

	@FindBy(name = "city")
	private WebElement cityDD;

	@FindBy(name = "pin")
	private WebElement pincodeTextBx;

	@FindBy(name = "arealoc")
	private WebElement areaTextBx;

	@FindBy(name = "nominee_name")
	private WebElement nomNameTextBx;

	@FindBy(name = "nominee_ac_no")
	private WebElement nomAccTextBx;

	@FindBy(name = "acctype")
	private WebElement accTypeDD;

	@FindBy(name = "submit")
	private WebElement submitBtn;

	// Initialisation
	public AccountRegistrationFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNameTextBx() {
		return nameTextBx;
	}

	public WebElement getGenderDD() {
		return genderDD;
	}

	public WebElement getMobTextBx() {
		return mobTextBx;
	}

	public WebElement getEmailTextBx() {
		return emailTextBx;
	}

	public WebElement getLandLineTextBx() {
		return landLineTextBx;
	}

	public WebElement getDobTextBx() {
		return dobTextBx;
	}

	public WebElement getPanTextBx() {
		return panTextBx;
	}

	public WebElement getCitizenTextBx() {
		return citizenTextBx;
	}

	public WebElement getHomeAddTextBx() {
		return homeAddTextBx;
	}

	public WebElement getOfficeAddTextBx() {
		return officeAddTextBx;
	}

	public WebElement getStateDD() {
		return stateDD;
	}

	public WebElement getCityDD() {
		return cityDD;
	}

	public WebElement getPincodeTextBx() {
		return pincodeTextBx;
	}

	public WebElement getAreaTextBx() {
		return areaTextBx;
	}

	public WebElement getNomNameTextBx() {
		return nomNameTextBx;
	}

	public WebElement getNomAccTextBx() {
		return nomAccTextBx;
	}

	public WebElement getAccTypeDD() {
		return accTypeDD;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	// Business Logic

	public void selectDD(String GENDER, String STATE, String CITY, String ACCOUNT) {
		Select gen = new Select(genderDD);
		gen.selectByVisibleText(GENDER);

		Select st = new Select(stateDD);
		st.selectByVisibleText(STATE);

		Select ct = new Select(cityDD);
		ct.selectByVisibleText(CITY);

		Select ac = new Select(accTypeDD);
		ac.selectByVisibleText(ACCOUNT);

	}

}
