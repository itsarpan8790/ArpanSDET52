package com.bixi.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementaion extends BaseClass implements ITestListener {
	//WebDriver sdriver;

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String FS = new JavaUtility().systemDateInformat() + result.getName();
		WebDriverUtility.takeScreenshot(sdriver, FS);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
