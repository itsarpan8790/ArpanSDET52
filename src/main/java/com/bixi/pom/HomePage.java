package com.bixi.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Declaration
	@FindBy(xpath = "//a[text()='Staff Login']")
	private WebElement staffLoginLink;

	@FindBy(xpath = "//img[@class='logo_img']")
	private WebElement homeLogo;

	@FindBy(xpath = "//li[text()='Open Account']")
	private WebElement openAccountLink;

	@FindBy(xpath = "//li[contains(.,'Apply Debit Card')]")
	private WebElement applyDebitCardLink;

	@FindBy(xpath = "//a[contains(.,'Internet Banking')]/ancestor::li")
	private WebElement iBankingLink;

	@FindBy(xpath = "//li[text()='Register']")
	private WebElement iBankingRegisterLink;

	@FindBy(xpath = "//li[text()='Login ']")
	private WebElement iBankingLoginLink;

	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fundTransferLink;

	// Initialisation
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilisation
	public WebElement getStaffLoginLink() {
		return staffLoginLink;
	}

	public WebElement getHomeLogo() {
		return homeLogo;
	}

	public WebElement getOpenAccountLink() {
		return openAccountLink;
	}

	public WebElement getApplyDebitCardLink() {
		return applyDebitCardLink;
	}

	public WebElement getiBankingLink() {
		return iBankingLink;
	}

	public WebElement getiBankingRegisterLink() {
		return iBankingRegisterLink;
	}

	public WebElement getiBankingLoginLink() {
		return iBankingLoginLink;
	}

	public WebElement getFundTransferLink() {
		return fundTransferLink;
	}

}
