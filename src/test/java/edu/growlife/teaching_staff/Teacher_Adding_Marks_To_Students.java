package edu.growlife.teaching_staff;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.excelsheet;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.Calender_Utilities;
import com.commonutilities.genericutilities.Dropdown_Utilities;
import com.commonutilities.genericutilities.ExcelUtilitiesnew;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Java_Utility;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.commonutilities.genericutilities.TestNGclass;
import com.commonutilities.genericutilities.Wait_Utilities;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;
import com.sms.objectrepository.elements.teacher.Teacher_dashboardpage;
import com.sms.objectrepository.elements.teacher.exampreviewpage;
import com.sms.objectrepository.elements.teacher.mystudent_exampage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teacher_Adding_Marks_To_Students extends TestNGclass
{
	@Test
	public  void Teacher_Adding_Marks_To_Studentss() 
	{
		Map<String, String> map = excelutility.getdata(excelsheet.ADMINMODULE.getsheetname(), "Teacher_Adding_Marks_To_Students");
		Loginpage login=new Loginpage(driver);
		Teacher_dashboardpage tpage=new Teacher_dashboardpage(driver);
		exampreviewpage exam=new exampreviewpage(driver);
		mystudent_exampage stdexam=new mystudent_exampage(driver);

		login.loginaction(proputility.getpropertyfiledata(propertkeys.TUSERNAME), proputility.getpropertyfiledata(propertkeys.TPASSWORD));
		// click on exam tab and click on my student exam tab
		tpage.clickexamtab_clickmystdmarkstab();
		//select grade
		exam.selectgrade(dropdownutility, 1);
		waitutility.waitforpageload(driver, 20);
		//select exam and click on submit
		String sub = map.get("subject");
		exam.selectexam(dropdownutility, sub);
		waitutility.waitforpageload(driver, 10);
		stdexam.clickonstd_editbtn();
		stdexam.clearmarksand_entermarks(map.get("mathmarks"));
		stdexam.sbtbuttonafter_exammarksentered();
		stdexam.handlemsg_popup(waitutility, driver, 10);
		//WebElement successmsg = driver.findElement(By.xpath("//div[@class='modal-body bgColorWhite']/../../../..//div[@class='modal msk-fade']/following-sibling::div[@id='update_Success']//strong"));
		//waitutility.waitforinvisibility(driver, 010, successmsg);
		tpage.teachersignout();
		javautility.consoleprint("test case is pass"+calenderutility.getcurrentdatetime());
	}
}

