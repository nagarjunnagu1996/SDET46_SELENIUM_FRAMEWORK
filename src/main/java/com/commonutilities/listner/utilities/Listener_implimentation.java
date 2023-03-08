package com.commonutilities.listner.utilities;

import java.io.IOException;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.commonutilities.genericutilities.TestNGclass;

public class Listener_implimentation implements ISuiteListener,ITestListener,IClassListener
{

	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("onBeforeClass---test");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("onAfterClass---class");
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onBeforeClass----suite");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish----suite");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart--test");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			TestNGclass.class.cast(result.getMethod().getInstance()).selutility.takescreenshot(result.getMethod()
					.getRealClass().getSimpleName(), TestNGclass.class.cast(result.getMethod().getInstance()).calenderutility);
		} catch (IOException e) {

		}
		System.out.println("onTestFailure---test");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart----test");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish---test");
	}

}
