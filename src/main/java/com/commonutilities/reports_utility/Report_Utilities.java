package com.commonutilities.reports_utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.Calender_Utilities;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
/**
 * 
 * @author nagarjuna m
 *
 */
public class Report_Utilities 
{
	public ExtentReports report;
	public Report_Utilities()
	{
		init();
	}
/**
 * 
 */
public void init()
{
	Propertyfile_Utilitiesnew properutility=null;
	try {
		 properutility=new Propertyfile_Utilitiesnew(Framework_Constatnts.EXTENT_REPORT_PROPERTYFILE_PATH);
		 
	} catch (Exception e) {
		
	}
	String overriderornot=properutility.getpropertyfiledata(propertkeys.OVERRIDEREPORT);
	String randomname="";
	if(overriderornot.equalsIgnoreCase("no"))
	{
		randomname="_"+new Calender_Utilities().getcurrentdatetime();
	}
	
	 ExtentSparkReporter spark = new ExtentSparkReporter(Framework_Constatnts.EXTENT_REPORT_FOLDER_PATH+"extent report"+randomname+".html");
	spark.config().setDocumentTitle(properutility.getpropertyfiledata(propertkeys.EXTENTREPORTTITLE));
	spark.config().setReportName(properutility.getpropertyfiledata(propertkeys.EXTENTREPORTNAME));
	spark.config().setTheme(Theme.DARK);
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("Browser", properutility.getpropertyfiledata(propertkeys.BROWSER));
	report.setSystemInfo("os", System.getProperty("os.name"));
}
/**
 * this method is used to create test case name tab in extent reports.
 * @param testname
 */
public void createtest(String testname)
{
	ExtentTest test = report.createTest(testname);
  UtilityInstanceTransfer.setExtentTest(test);
}
/**
 * this method is used to log the fail message
 * @param message
 */
public void fail(ExtentTest test,String message,Throwable errormessage)
{
	test.fail(message) ;
	test.fail(errormessage);
}


/**
 * this method is used to log the skip throwable message
 * @param errormessage
 */
public void skip(ExtentTest test,String message,Throwable errormessage)
{
	test.skip(message);
	test.skip(errormessage);
}
/**
 * this method is used to log the pass message
 * @param message
 */
public void pass(ExtentTest test,String message)
{
	test.pass(message);
}
/**
 * this method is used to log the warning message
 * @param message
 */
public void warning(ExtentTest test,String message)
{
	test.warning(message);
}

/**
 * this method is used to log information of the method
 * @param message
 */
public void info(ExtentTest test,String message)
{
	test.info(message);
	System.out.println(message);
}
/**
 * this method is used attach the screenshot if test case is failed
 * @param extentTest
 * @param strategy
 * @param title
 */
public void attachscreenshot(ExtentTest test,String title  ,String strategy,String screenshotpath)
{
	if(strategy.equalsIgnoreCase("base64"))
	{
		test.addScreenCaptureFromBase64String(screenshotpath,title);
	}
	else {
		test.addScreenCaptureFromPath(screenshotpath,title);
	}
}
/**
 * this method is used to save the report
 */
public void savereport()
{
	report.flush();
}
public void addauthor(ExtentTest test, String...names ) 
{
	test.assignAuthor(names);
	
}
public void addcategory(ExtentTest test, String...names ) {
	test.assignCategory(names);
	
}
}

