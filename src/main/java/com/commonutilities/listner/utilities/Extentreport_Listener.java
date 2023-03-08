package com.commonutilities.listner.utilities;

import org.testng.ISuite;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.generic.annotations.Report;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.TestNGclass;
import com.commonutilities.reports_utility.Report_Utilities;
import com.commonutilities.reports_utility.UtilityInstanceTransfer;

public class Extentreport_Listener implements ITestListener,ISuiteListener
{
	private Report_Utilities report;
	public static Report_Utilities sreport;

	@Override
	public void onStart(ISuite suite) {
		report =new Report_Utilities();
		
		sreport=report;
	}

	@Override
	public void onFinish(ISuite suite)
	{
		System.out.println("on finish----suite");
		report.savereport();
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("on start--test");

	}


	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("onTestStart");
		report.createtest(result.getMethod().getMethodName());	
		Report reportannotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportannotation.author());
		System.out.println(reportannotation.category());
		report.addauthor(UtilityInstanceTransfer.getExtentTest(),reportannotation.author());
		report.addcategory(UtilityInstanceTransfer.getExtentTest(),reportannotation.category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success");
		report.pass(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is pass ");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure---test");
		report.fail(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is failed ", result.getThrowable());


		String screenshotpath=null;

		screenshotpath=TestNGclass.class.cast(result.getMethod().getInstance()).selutility.takescreenshot();
		//report.attachscreenshot(screenshotpath, result.getMethod().getMethodName(), "Base64");
		report.attachscreenshot(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName(), "Base64", screenshotpath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on skipped");
		report.skip(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is fail ", result.getThrowable());

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
	public void onFinish(ITestContext context) {
		System.out.println("on finish test----->test");

	}

}
