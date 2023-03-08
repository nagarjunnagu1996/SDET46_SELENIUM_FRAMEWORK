package com.commonutilities.listner.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryimplimentation implements IRetryAnalyzer
{
int count;
	@Override
	public boolean retry(ITestResult result) {
		int maxcount=2;
		if(count<maxcount)
		{
			count++;
			return true;
			
		}
		return false;
	}

}
