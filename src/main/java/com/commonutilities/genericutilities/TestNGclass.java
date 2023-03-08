package com.commonutilities.genericutilities;


import java.sql.SQLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.commonutilities.enumsutility.excelsheet;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.listner.utilities.Extentreport_Listener;
import com.commonutilities.reports_utility.Report_Utilities;
import com.sms.objectrepository.elements.organisation_chief.Admin_Dashbordpage;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;

public class TestNGclass
{

	public WebDriver driver;
	protected ExcelUtilitiesnew excelutility;
	public Propertyfile_Utilitiesnew proputility;
	public Selenium_utility selutility;
	protected Wait_Utilities waitutility;
	protected Java_Utility javautility;
	protected Interactions_Utilities interactioutility;
	protected Popup_Utilities popuputility;
	protected Dropdown_Utilities dropdownutility;
	protected Database_Utilitynew databaseutility;
	public Calender_Utilities calenderutility;
	public String browser;
	public Report_Utilities report;
	

	@Parameters(value="browser")
	@BeforeClass(alwaysRun = true)
	public void openbrowsser(@Optional String browser)
	{
		report=Extentreport_Listener.sreport;
		excelutility=new ExcelUtilitiesnew(Framework_Constatnts.EXCEL_FILE_PATH);
		proputility =new Propertyfile_Utilitiesnew(Framework_Constatnts.PROPERTY_FILE_PATH);
		selutility=new Selenium_utility();
		waitutility=new Wait_Utilities();
		javautility=new Java_Utility();
		//interactioutility=new Interactions_Utilities();
		popuputility=new Popup_Utilities();
		dropdownutility=new Dropdown_Utilities();
		try {
			databaseutility=new Database_Utilitynew(Framework_Constatnts.DBURL, 
					Framework_Constatnts.DBPASSWORD, Framework_Constatnts.DBPASSWORD);
		} catch (SQLException e) {

		}
		 calenderutility=new Calender_Utilities();

		if(browser==null)
		{

			browser= proputility.getpropertyfiledata(propertkeys.BROWSER);

		}
		this.browser=browser;
		System.out.println(browser);
		driver= selutility.launchbrowser(browser);
		selutility.maximizebrowser();
		System.out.println("browser is launched");
		selutility.launchapplication(proputility.getpropertyfiledata(propertkeys.URL));
	}

	@AfterClass(alwaysRun = true)
	public void closebrowser()
	{
		//driver.quit();
		excelutility.close();
		databaseutility.closeDB();
		proputility.closeproperty();
	}



}
