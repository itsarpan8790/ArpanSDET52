package com.bixi.BaseTestScripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bixi.genericutility.BaseClass;
import com.bixi.pom.CustomerLoginPage;
import com.bixi.pom.Customer_Pass_ChangePage;
import com.bixi.pom.Customer_ProfilePage;
import com.bixi.pom.Ebanking_Reg_FormPage;
import com.bixi.pom.HomePage;
//@Listeners(com.bixi.genericutility.ListenerImplementaion.class)
public class InternetBankingTest extends BaseClass {

	@Test(groups = "system")
	public void iBankingChangePassword() throws Throwable {

		// Step 1. MouseHovering and clicking Login
		HomePage hp = new HomePage(driver);
		WebElement iBankinkLink = hp.getiBankingLink();
		WebElement iBankingLoginLink = hp.getiBankingLoginLink();
		wUtil.multipleAction(driver, iBankinkLink, iBankingLoginLink);
		wUtil.scrollUpAction(driver);
		Thread.sleep(2000);

		// User Login
		CustomerLoginPage clp = new CustomerLoginPage(driver);
		clp.loginAsCutomer(CUSTOMERID, PASSWORD);
		
		
		// Step 5.Changepassword
		Customer_ProfilePage cpp = new Customer_ProfilePage(driver);
		cpp.getChangePwdLink().click();

		Customer_Pass_ChangePage cpc = new Customer_Pass_ChangePage(driver);
		cpc.getOldPWTextBx().sendKeys(PASSWORD);
		Thread.sleep(1000);
		cpc.getCnfmOldPWTextBx().sendKeys(PASSWORD);
		Thread.sleep(1000);
		cpc.getNewPWTextBx().sendKeys(NEWPASSWORD);
		Thread.sleep(1000);
		cpc.getSubmitBtn().click();
		String confirmationPopupText = wUtil.getAlertPopUpText(driver);
		Thread.sleep(500);
		wUtil.
		handleAlertPopUp(driver);
		//Handle Password Change PropertyFile
//		fUtil.writeDataToPropertyFile("password", NEWPASSWORD);
//		fUtil.writeDataToPropertyFile("newpassword", PASSWORD);
		
		//Handle Password Change Excel
		eUtil.writeDataIntoExcel("NeyazUTC_05", 1, 8, NEWPASSWORD);
		eUtil.writeDataIntoExcel("NeyazUTC_05", 2, 8, PASSWORD);
		System.out.println("Excel Update successfully");
		

		// Step 5.Validating
		if (confirmationPopupText.contains("Success")) {
			System.out.println("Pass");
			System.out.println("Password changed Successfully and is Verified ");
		} else {
			System.out.println("Failed");
			System.out.println("Password not changed Successfully and is Verified ");

		}
		// Step 6. Logout
		cpp.getLogOutBtn().click();
		Thread.sleep(2000);
		
	}

	@Test(groups = "smoke")
	public void registerForIBAnotherTab() throws Throwable {

		HomePage hp = new HomePage(driver);
		WebElement internetBankingButton = hp.getiBankingLink();
		wUtil.scrollUpAction(driver);
		WebElement IBRegisterBtn = hp.getiBankingRegisterLink();
		Thread.sleep(2000);

		wUtil.moveToElementAction(driver, internetBankingButton);
		wUtil.moveToElementAction(driver, IBRegisterBtn);
		wUtil.contextClickAction(driver);
		wUtil.keyPressT();

		// Switching child popup
		wUtil.switchToWindow(driver, "ebanking_reg_form");
		// Validation
		String expTitle = "Internet Banking Registration";
		String actTitle = driver.getTitle();
		if (actTitle.equals(expTitle))
			System.out.println("Internet Banking Registration Page is Displayed and Verified");

	
	}

	@Test(groups = "smoke")
	public void regiterForIBankingAndRefresh_ManTC13() throws Throwable {

		HomePage hp = new HomePage(driver);
		// Hovering to diff elements
		WebElement internetBankingButton = hp.getiBankingLink();
		wUtil.scrollDownAction(driver);
		Thread.sleep(1000);
		WebElement IBRegisterBtn = hp.getiBankingRegisterLink();
		wUtil.moveToElementAction(driver, internetBankingButton);
		wUtil.moveToElementAction(driver, IBRegisterBtn);
		wUtil.ClickAction(driver, IBRegisterBtn);

		// Reading thru Excel and entering values.
		eUtil.readMultipleDataFromExcel("ManjuTC_13", driver);

		// Entering Dob
		Ebanking_Reg_FormPage erfp = new Ebanking_Reg_FormPage(driver);
		WebElement DOB = erfp.getDob();
		DOB.click();
		DOB.sendKeys("01011999");

		driver.navigate().refresh();

		// validation

		System.out.println("Passed and Verified");// doubt

	}
}
