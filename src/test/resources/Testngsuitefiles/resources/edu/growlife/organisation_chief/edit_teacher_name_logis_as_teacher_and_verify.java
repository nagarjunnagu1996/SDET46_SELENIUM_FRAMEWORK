package edu.growlife.organisation_chief;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.growlife.utilities.ExcelUtilitiesnew;
import com.growlife.utilities.Framework_Constatnts;
import com.growlife.utilities.Java_Utility;
import com.growlife.utilities.Propertyfile_Utilitiesnew;
import com.growlife.utilities.Selenium_utility;
import com.growlife.utilities.Wait_Utilities;
import com.growlife.utilities.Enums.excelsheet;
import com.growlife.utilities.Enums.propertkeys;
import com.sms.objectrepository.elements.admin_dashbordpage;
import com.sms.objectrepository.elements.allteacher_page;
import com.sms.objectrepository.elements.edit_teacherpage;
import com.sms.objectrepository.elements.loginpage;
import com.sms.objectrepository.elements.teacher.teacher_dashboardpage;
import com.sms.objectrepository.elements.teacher.teacher_profilepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class edit_teacher_name_logis_as_teacher_and_verify {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		ExcelUtilitiesnew excelutility=new ExcelUtilitiesnew(Framework_Constatnts.EXCEL_FILE_PATH);
		Map<String, String> testdata = excelutility.getdata(excelsheet.ADMINMODULE.getsheetname(), "edit_teacher_name_logis_as_teacher_and_verify");
		Propertyfile_Utilitiesnew proputility =new Propertyfile_Utilitiesnew(Framework_Constatnts.PROPERTY_FILE_PATH);
		Selenium_utility selutility=new Selenium_utility();
		Wait_Utilities waitutility=new Wait_Utilities();
		Java_Utility javautility=new Java_Utility();
		loginpage loginp=new loginpage(driver);
		allteacher_page alteacher=new allteacher_page(driver);
		edit_teacherpage editteacher=new edit_teacherpage();
		admin_dashbordpage adashb=new admin_dashbordpage(driver);
		teacher_dashboardpage tdashp=new teacher_dashboardpage();
		teacher_profilepage tprofile=new teacher_profilepage();
		WebDriver driver=selutility.launchbrowser("chrome");
		selutility.maximizebrowser();
		System.out.println(proputility.getpropertyfiledata(propertkeys.URL));
		selutility.launchapplication(proputility.getpropertyfiledata(propertkeys.URL));
		loginp.loginaction(proputility.getpropertyfiledata(propertkeys.AUSERNAME), proputility.getpropertyfiledata(propertkeys.APASSWORD);
		adashb.clickteacher_selectallteacher();
		alteacher.teschersearchfield(testdata.get("teacher_name"));
		//driver.findElement(By.xpath("//input[@type='search']")).sendKeys(testdata.get("teacher_name"));
		alteacher.teachereditingbtn();
		//driver.findElement(By.xpath("//a[.='Edit']/../../../tr[1]/td[3]/a[1]")).click();
		editteacher.editteachername(testdata.get("updated_teachername"));
		//driver.findElement(By.xpath("//input[@id='full_name1']")).sendKeys(testdata.get("updated_teachername"));
		//driver.findElement(By.xpath("//button[@id='btnSubmit1']")).click();
		waitutility.waitforpageload(driver, 50);
		javautility.pausewebaction(5000);
		adashb.subjecttabclick();
		//driver.findElement(By.xpath("//span[.='Subject']")).click();
		adashb.adminsignout();
		//driver.findElement(By.xpath("//span[.='Ingenious Developer1']")).click();
		//driver.findElement(By.xpath("//a[.='Sign out']")).click();
		loginp.loginaction(proputility.getpropertyfiledata(propertkeys.TUSERNAME), proputility.getpropertyfiledata(propertkeys.TPASSWORD));
		//driver.findElement(By.id("email")).sendKeys(proputility.getpropertyfiledata(propertkeys.TUSERNAME));
		//driver.findElement(By.id("password")).sendKeys(proputility.getpropertyfiledata(propertkeys.TPASSWORD));
		//driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		tdashp.teacher_profile();
		//driver.findElement(By.xpath("//span[.='My Profile']")).click();
		tfullname=tprofile.teacher_profilename();
		//WebElement tname = driver.findElement(By.xpath("//h4[@id='hname']"));
		//String tfullname = tname.getText();
		if(tfullname.equals(testdata.get("teacher_pagevrify_text")))
		{
			System.out.println("test case is pass");
		}

	}

}
