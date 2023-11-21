package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Debit_Card_FormPage {
	// Declaration
	@FindBy(name = "dbt_crd_submit")
	private WebElement SubmitBtn;

	// Initialisation
	public Debit_Card_FormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

}
