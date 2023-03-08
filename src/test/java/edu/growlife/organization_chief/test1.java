package edu.growlife.organization_chief;


import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.excelsheet;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.enumsutility.tabnames;
import com.commonutilities.generic.annotations.Report;
import com.commonutilities.genericutilities.TestNGclass;
import com.commonutilities.reports_utility.UtilityInstanceTransfer;
import com.github.dockerjava.api.model.ContainerNetworkSettings;
import com.sms.objectrepository.elements.organisation_chief.Admin_Dashbordpage;
import com.sms.objectrepository.elements.organisation_chief.Commonpage_Elements;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;
import com.sms.objectrepository.elements.organisation_chief.gradepreview_page;
import com.sms.objectrepository.elements.organisation_chief.subjectpreviewpage;
import com.sms.objectrepository.elements.teacher.mystudentpage;

public class test1 extends TestNGclass
{
	@Report(author="nagu")
	@Test
	public void admin() throws InterruptedException
	{
		Loginpage loginp=new Loginpage(driver);
		Commonpage_Elements common=new Commonpage_Elements(driver);
		gradepreview_page gradep=new gradepreview_page(driver);
		Map<String, String> testdata = excelutility.getdata(excelsheet.ADMINMODULE.getsheetname(),"admin");
		subjectpreviewpage subpreview=new subjectpreviewpage(driver);
		Admin_Dashbordpage adminpage=new Admin_Dashbordpage(driver);
		mystudentpage mystdp=new mystudentpage(driver);


		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("Student_Management_System"));
		javautility.consoleprint("loginpage is dispalyed");
		loginp.loginaction(javautility.decodestring(proputility.getpropertyfiledata(propertkeys.AUSERNAME)),javautility.decodestring(proputility.getpropertyfiledata(propertkeys.APASSWORD)));
		report.info(UtilityInstanceTransfer.getExtentTest(), "admin is loged into application");
		String dasburl = driver.getCurrentUrl();
		Assert.assertTrue(dasburl.contains("/view/dashboard.php"));
		javautility.consoleprint("admin dash bord is displayed");
		common.clicktab(tabnames.GRADE);
		report.info(UtilityInstanceTransfer.getExtentTest(), "grade page is displayed");
		System.out.println(testdata.get("grade"));
		gradep.entergradeanddetails(testdata.get("grade")+javautility.getrandomnumber(1000), testdata.get("admissionfee"), testdata.get("hallfee"));
		//String grade="grade";
		//String actualgrade=grade+javautility.getrandomnumber(100)
		report.info(UtilityInstanceTransfer.getExtentTest(), "grade details are submitted and grade range popup is displayed");
		gradep.enterrangeand_grade(waitutility, driver, testdata.get("graderange1"), testdata.get("grade1"));
		report.info(UtilityInstanceTransfer.getExtentTest(), "grade range is entered and submitted");
		//gradep.clickaddgradebtn(testdata.get("graderange2"), testdata.get("grade2"));
		common.clicktab(tabnames.SUBJECT);
		report.info(UtilityInstanceTransfer.getExtentTest(), "subject preview page is displayed");
		String suburl = driver.getCurrentUrl();
		Assert.assertTrue(suburl.contains("Student_Management_System/view/subject.php"));
		javautility.consoleprint("subject preview page is displayed");
		subpreview.entersubnameandsubmit(waitutility, driver, testdata.get("subjectname")+javautility.getrandomnumber(1000));
		adminpage.adminsignout();	
		report.info(UtilityInstanceTransfer.getExtentTest(), "login page is displayed");
		loginp.loginaction(proputility.getpropertyfiledata(propertkeys.TUSERNAME), proputility.getpropertyfiledata(propertkeys.TPASSWORD));
		Assert.assertTrue(driver.getCurrentUrl().contains("Student_Management_System/view/dashboard2.php"));
		javautility.consoleprint("teacher dash bord page is displayed");
		report.info(UtilityInstanceTransfer.getExtentTest(), "teacher is loged into application");
		// click on student tab
		mystdp.clickmystdtab();
		//click on grade and select grade
		mystdp.selectgrade(dropdownutility);
		String gradepage = driver.getCurrentUrl();
		Assert.assertTrue(gradepage.contains("private WebElement subjectsubmitbtn;"));
		javautility.consoleprint("grade page is displayed with all students");
		report.info(UtilityInstanceTransfer.getExtentTest(), "test case pass");
	}
}
