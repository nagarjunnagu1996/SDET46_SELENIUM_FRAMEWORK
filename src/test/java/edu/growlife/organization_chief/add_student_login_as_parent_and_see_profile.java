package edu.growlife.organization_chief;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.excelsheet;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.enumsutility.tabnames;
import com.commonutilities.generic.annotations.Report;
import com.commonutilities.genericutilities.ExcelUtilitiesnew;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Java_Utility;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.commonutilities.genericutilities.TestNGclass;
import com.commonutilities.genericutilities.Wait_Utilities;
import com.commonutilities.reports_utility.UtilityInstanceTransfer;
import com.sms.objectrepository.elements.organisation_chief.Admin_Dashbordpage;
import com.sms.objectrepository.elements.organisation_chief.Commonpage_Elements;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;
import com.sms.objectrepository.elements.organisation_chief.Student_Paymentpage;
import com.sms.objectrepository.elements.parent.parent_dashbordpage;

public class add_student_login_as_parent_and_see_profile extends TestNGclass
{
	@Report(author="nagarjun")
	@Test
	public  void add_student_login_as_parent_and_see_profiles() throws IOException 
	{
		String sheetname = excelsheet.ADMINMODULE.getsheetname();
		String exptestscript="add_student_login_as_parent_and_see_profile";
		Map<String, String> map = excelutility.getdata(sheetname, exptestscript);
		Admin_Dashbordpage apage=new Admin_Dashbordpage(driver);
		Student_Paymentpage spay=new Student_Paymentpage(driver);
		parent_dashbordpage ppage=new parent_dashbordpage(driver);
		Commonpage_Elements common=new Commonpage_Elements(driver);
		Loginpage login=new Loginpage(driver);

		// login as admin
		login.loginaction(javautility.decodestring(proputility.getpropertyfiledata(propertkeys.AUSERNAME)), javautility.decodestring(proputility.getpropertyfiledata(propertkeys.APASSWORD)));
		String dasburl = driver.getCurrentUrl();
		Assert.assertTrue(dasburl.contains("/view/dashboard.php"));
		javautility.consoleprint("admin dash bord is displayed");
		report.info(UtilityInstanceTransfer.getExtentTest(), "admin is loged into application");
		// click on myprofile tab
		Commonpage_Elements comon=new Commonpage_Elements(driver);
		comon.clicktab(tabnames.MYPROFILE);
		String profileurl = driver.getCurrentUrl();
		Assert.assertTrue(profileurl.contains("Student_Management_System/view/admin_profile.php"));
		javautility.consoleprint("admin my profile page is displayed");
		//click on student tab and click on add student tab
		apage.clickonstudentand_addstudent();
		//click on studentpayment button
		comon.clicktab(tabnames.STUDENTPAYMENT);
		// enter index number and click on submitt btn
		spay.enterdatato_indextextfield(map.get("index_number"));
		report.info(UtilityInstanceTransfer.getExtentTest(), "index number is entered and submitted and student details are displayed");;
		//waitutility.waitexplicit(driver, 10);
		spay.removeparentdetailspopup(waitutility, 20, driver);
		//admin signout
		apage.adminsignout();
		//report.info(UtilityInstanceTransfer.getExtentTest(), "admin logout and login page is displayed");
		waitutility.waitforpageload(driver, 10);
		//login as parent
		waitutility.verifloginypage(driver);
		login.loginaction(proputility.getpropertyfiledata(propertkeys.PUSERNAME), proputility.getpropertyfiledata(propertkeys.PPASSWORD));
		report.info(UtilityInstanceTransfer.getExtentTest(), "student parent is lagin and parent dashbord page will be displayed");
		comon.clicktab(tabnames.TEACHER);
		comon.clicktab(tabnames.SUBJECT);
		//ppage.subjecttabclick();
		comon.clicktab(tabnames.TIMETABLE);
		//click on attendance tab and click on my sons attendance tab
		ppage.clickonattendancetab_and_mysonsattendancetab(waitutility, driver, 20);
		report.info(UtilityInstanceTransfer.getExtentTest(), "parent viewing my sons attendance page");
		//parent signout
		ppage.parentsignout();
		//report.info(UtilityInstanceTransfer.getExtentTest(), "parent logout from application and login page is displayed");
		javautility.consoleprint("test case is pass");
	}
}
