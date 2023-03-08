package practice;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.excelsheet;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.enumsutility.tabnames;
import com.commonutilities.genericutilities.ExcelUtilitiesnew;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Java_Utility;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.commonutilities.genericutilities.TestNGclass;
import com.sms.objectrepository.elements.organisation_chief.Admin_Dashbordpage;
import com.sms.objectrepository.elements.organisation_chief.Commonpage_Elements;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;
import com.sms.objectrepository.elements.organisation_chief.gradepreview_page;

public class testngscript extends TestNGclass
{
	@Test
	public  void testscript() throws EncryptedDocumentException, IOException 
	{
		ExcelUtilitiesnew excelutility=new ExcelUtilitiesnew(Framework_Constatnts.EXCEL_FILE_PATH);
		Propertyfile_Utilitiesnew properutility=new Propertyfile_Utilitiesnew(Framework_Constatnts.PROPERTY_FILE_PATH);
		Selenium_utility selutility=new Selenium_utility();
		Java_Utility javautility=new Java_Utility();
		String sheetname = excelsheet.ADMINMODULE.getsheetname();
		Map<String, String> map = excelutility.getdata(sheetname, "Adding_Grade_Student_Teacher");
		javautility.consoleprintmap(map);
		Admin_Dashbordpage apage=new Admin_Dashbordpage(driver);
		Loginpage login=new Loginpage(driver);
		Commonpage_Elements commonp=new Commonpage_Elements(driver);
		gradepreview_page grade=new gradepreview_page(driver);

		//click on grade
		commonp.clicktab(tabnames.GRADE);
		//enter grade name , admission fee, hall fee and click
		grade.entergradeanddetails(map.get("garde"), map.get("admission_fee"), map.get("hall_fee"));
		grade.enterrangeand_grade(map.get("grade_range"), map.get("grade"));

	}
}
