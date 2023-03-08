package edu.growlife.organization_chief;

import java.io.IOException;
import java.util.Base64.Decoder;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.excelsheet;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.ExcelUtilitiesnew;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Java_Utility;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.commonutilities.genericutilities.TestNGclass;
import com.commonutilities.genericutilities.Wait_Utilities;
import com.sms.objectrepository.elements.organisation_chief.Admin_Dashbordpage;
import com.sms.objectrepository.elements.organisation_chief.Allteacher_Page;
import com.sms.objectrepository.elements.organisation_chief.Edit_Teacherpage;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;
import com.sms.objectrepository.elements.teacher.Teacher_Profilepage;
import com.sms.objectrepository.elements.teacher.Teacher_dashboardpage;

import com.sms.objectrepository.elements.teacher.Teacher_Profilepage;

public class Edit_Teacher_Name_Logis_As_Teacher_And_Verify extends TestNGclass
{
	@Test
	public void Edit_Teacher_Name_Logis_As_Teacher()
	{
		
		Map<String, String> testdata = excelutility.getdata(excelsheet.ADMINMODULE.getsheetname(), "edit_teacher_name_logis_as_teacher_and_verify");
		Loginpage loginp=new Loginpage(driver);
		Admin_Dashbordpage adashb=new Admin_Dashbordpage(driver);
		Edit_Teacherpage editteacher=new Edit_Teacherpage(driver);
		Allteacher_Page allteacher=new Allteacher_Page(driver);
		Teacher_dashboardpage tdashb=new Teacher_dashboardpage(driver);
		Teacher_Profilepage tprofile=new Teacher_Profilepage(driver);
		
		String username = javautility.decodestring(proputility.getpropertyfiledata(propertkeys.AUSERNAME));
		String password =javautility.decodestring(proputility.getpropertyfiledata(propertkeys.APASSWORD));
		loginp.loginaction(username,password);
		adashb.clickteacher_selectallteacher(javautility);
		//enter teacher name and search and click on edit
		allteacher.teachersearchfield(testdata.get("teacher_name"));
		allteacher.teachereditingbtn();

		// enter teacher new name and click on submitt
		String newname = testdata.get("updated_teachername");
		editteacher.enterteachernameandsubmit(newname);
		waitutility.waitforpageload(driver, 50);
		javautility.pausewebaction(5000);
		//click on subject tab
		adashb.subjecttabclick();
		//admin signout
		adashb.adminsignout();

		//login as teacher by entering credentials
		loginp.loginaction(proputility.getpropertyfiledata(propertkeys.TUSERNAME), proputility.getpropertyfiledata(propertkeys.TPASSWORD));
		// click on teacher profile
		tdashb.teacher_profileclick();
		//get  teacher name text from techer profile
		String tname = tprofile.teacher_profilename();
Assert.assertEquals(tname, testdata.get("teacher_pagevrify_text"));
		//if(tname.equals(testdata.get("teacher_pagevrify_text")))
			System.out.println("test case is pass");
	}
}
