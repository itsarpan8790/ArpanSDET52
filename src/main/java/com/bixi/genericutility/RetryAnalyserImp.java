package com.bixi.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImp implements IRetryAnalyzer {

	int count=1;
	int limit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<=limit) {
			count++;
			return true;
		}
		return false;
	}
	

}
