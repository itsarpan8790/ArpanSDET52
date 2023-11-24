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

		String expText="No field should be empty";
		String actText = wUtil.getAlertPopUpText(driver);
		
		//Validation
		if(actText.equals(expText))
		System.out.println("Error message is Displayed and is Verified");
		else
			System.out.println("Error message not Displayed and Verified and Failed");
		Thread.sleep(5000);
		wUtil.handleAlertPopUp(driver);

	}
}

/**
 * iRetryAnalyser execution
 */
//@Test(groups = "smoke",retryAnalyzer = com.bixi.genericutility.RetryAnalyserImp.class)
//public void applyForDebitCardWithBlankFields_NeyazTC15() throws Throwable {
//
//	HomePage hp = new HomePage(driver);
//	hp.getApplyDebitCardLink().click();
//
//	eUtil.readMultipleDataFromExcel("NeyazTC_15", driver);
//
//	Thread.sleep(2000);
//	Debit_Card_FormPage dcf = new Debit_Card_FormPage(driver);
//	dcf.getSubmitBtn().click();
//
//	String expText="No field should be empty";
//	String actText = wUtil.getAlertPopUpText(driver);
//	
//	//Validation
//	if(actText.equals(expText))
//	System.out.println("Error message is Displayed and is Verified");
//	else
//		System.out.println("Error message not Displayed and Verified and Failed");
//	Thread.sleep(5000);
//	wUtil.handleAlertPopUp(driver);
//
//}

