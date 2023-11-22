package com.bixi.BaseTestScripts;

import org.testng.annotations.Test;

import com.bixi.genericutility.BaseClass;
import com.bixi.pom.Debit_Card_FormPage;
import com.bixi.pom.HomePage;

public class DebitCardTest extends BaseClass {

	@Test(groups = "smoke")
	public void applyForDebitCardWithBlankFields_NeyazTC15() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.getApplyDebitCardLink().click();

		eUtil.readMultipleDataFromExcel("NeyazTC_15", driver);

		Thread.sleep(2000);
		Debit_Card_FormPage dcf = new Debit_Card_FormPage(driver);
		dcf.getSubmitBtn().click();

		String errormsg = wUtil.getAlertPopUpText(driver);
		System.out.println("Error message displayed as: " + errormsg);
		Thread.sleep(5000);
		wUtil.handleAlertPopUp(driver);

	}
}
