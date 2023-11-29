package com.bixi.BaseTestScripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bixi.genericutility.BaseClass;
import com.bixi.pom.AccountRegistrationFormPage;
import com.bixi.pom.Customer_RegForm_ConfirmPage;
import com.bixi.pom.HomePage;

//@Listeners(com.bixi.genericutility.ListenerImplementaion.class)
public class OpenAccountTest extends BaseClass {

	@Test(groups = "regression")
	public void applyNewBankAccount_NeyazTC05() throws Throwable {

		ArrayList<String> al = new ArrayList<String>();
		int rowCount = eUtil.getLastRowNumber("NeyazUTC_05");
		for (int i = 0; i <= rowCount; i++) {
			String data = eUtil.readDataFromExcelFile("NeyazUTC_05", i, 1);
			al.add(data);
		}
		HomePage hp = new HomePage(driver);
		hp.getOpenAccountLink().click();

		AccountRegistrationFormPage arp = new AccountRegistrationFormPage(driver);
		// Entering Textfields
		int ranNum = jUtil.getRandomNumber();
		arp.getNameTextBx().sendKeys(al.get(0) + ranNum);
		Thread.sleep(5000);
		arp.getMobTextBx().sendKeys(al.get(1));
		arp.getEmailTextBx().sendKeys(al.get(2));
		arp.getLandLineTextBx().sendKeys(al.get(3));
		arp.getPanTextBx().sendKeys(al.get(4));
		arp.getCitizenTextBx().sendKeys(al.get(5));
		arp.getHomeAddTextBx().sendKeys(al.get(6));
		arp.getOfficeAddTextBx().sendKeys(al.get(7));

		arp.getPincodeTextBx().sendKeys(al.get(8));
		arp.getAreaTextBx().sendKeys(al.get(9));
		arp.getNomNameTextBx().sendKeys(al.get(10));
		arp.getNomAccTextBx().sendKeys(al.get(11));

		// Selecting Drpdowns
		String GENDER = eUtil.readDataFromExcelFile("NeyazUTC_05", 0, 5);
		String STATE = eUtil.readDataFromExcelFile("NeyazUTC_05", 1, 5);
		String CITY = eUtil.readDataFromExcelFile("NeyazUTC_05", 2, 5);
		String ACCOUNT = eUtil.readDataFromExcelFile("NeyazUTC_05", 3, 5);

		arp.selectDD(GENDER, STATE, CITY, ACCOUNT);

		// Entering Dob
		String DOB = eUtil.readDataFromExcelFile("NeyazUTC_05", 4, 5);
		arp.getDobTextBx().click();
		arp.getDobTextBx().sendKeys(DOB);

		// Clicking on Submit
		arp.getSubmitBtn().click();

		Customer_RegForm_ConfirmPage crf = new Customer_RegForm_ConfirmPage(driver);
		crf.getConfirmBtn().click();

		// Handling PopUp
		String confirmPopText = wUtil.getAlertPopUpText(driver);
		wUtil.handleAlertPopUp(driver);

		// Validation
		if (confirmPopText.contains("Application submitted successfully")) {
			System.out.println("Pass");
			System.out.println("Account created Successfully");
		} else {
			System.out.println("Failed");
			System.out.println("Account not created");
		}

		// Extracting Application No
		String applicationNo = "";
		for (int i = 0; i < confirmPopText.length(); i++) {
			if (Character.isDigit(confirmPopText.charAt(i))) {
				applicationNo = applicationNo + confirmPopText.charAt(i);
			}
		}
		System.out.println("Application no is :" + applicationNo);

	}
}