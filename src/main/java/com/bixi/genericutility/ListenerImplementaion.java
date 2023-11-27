package com.bixi.genericutility;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementaion extends BaseClass implements ITestListener {
	ExtentSparkReporter htmlReport;
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");

		htmlReport.config().setDocumentTitle("TestYantra");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("BIXI");

		report = new ExtentReports();

		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("URL", "http://rmgtestingserver/domain/Online_Banking_System/");
		report.setSystemInfo("Reporter_Name", "Arpan");

	}

	@Override
	public void onTestStart(ITestResult result) {
		String METHODNAME = result.getName();
		test = report.createTest(METHODNAME);
		Reporter.log(METHODNAME + " --TestScript Execution Starts From Here--");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String METHODNAME = result.getName();
		test.log(Status.PASS, METHODNAME + "  is Passed");
		Reporter.log(METHODNAME + " --TestScript Executed Successfully");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String Timestamp = LocalDateTime.now().toString().replace(':', '-');
		String FS = Timestamp + result.getName();
		
		WebDriverUtility.takeScreenshot(sdriver, FS);// Trycatch

		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, FS + "  is Failed");
		Reporter.log(FS + " --TestScript Execution Failed");
		
		test.addScreenCaptureFromPath(FS);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String METHODNAME = result.getName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, METHODNAME + "  is Skipped");
		Reporter.log(METHODNAME + " --TestScript Execution Skipped");
	}

	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
