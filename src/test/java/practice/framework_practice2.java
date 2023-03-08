package practice;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.commonutilities.enumsutility.excelsheet;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.ExcelUtilitiesnew;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Java_Utility;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;

public class framework_practice2 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		ExcelUtilitiesnew excelutility=new ExcelUtilitiesnew(Framework_Constatnts.EXCEL_FILE_PATH);
		Propertyfile_Utilitiesnew properutility=new Propertyfile_Utilitiesnew(Framework_Constatnts.PROPERTY_FILE_PATH);
		Selenium_utility selutility=new Selenium_utility();
		Java_Utility javautility=new Java_Utility();
		String sheetname = excelsheet.ADMINMODULE.getsheetname();
		Map<String, String> map = excelutility.getdata(sheetname, "Adding_Grade_Student_Teacher");
	javautility.consoleprintmap(map);
	WebDriver driver =selutility.launchbrowser("chrome");
	selutility.maximizebrowser();
	selutility.launchapplication(properutility.getpropertyfiledata(propertkeys.URL));
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(javautility.decodestring(properutility.getpropertyfiledata(propertkeys.AUSERNAME)));
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(javautility.decodestring(properutility.getpropertyfiledata(propertkeys.APASSWORD)));
	driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
	driver.findElement(By.xpath("//span[.='Grade']")).click();
	driver.findElement(By.xpath("//input[@id='name']")).sendKeys(map.get("garde"));
	driver.findElement(By.xpath("//input[@id='admission_fee']")).sendKeys(map.get("admission_fee"));
	driver.findElement(By.xpath("//input[@id='hall_charge']")).sendKeys(map.get("hall_fee"));
	driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
	driver.findElement(By.xpath("//input[@id='mark_range_text_1']")).sendKeys(map.get("grade_range"));
	driver.findElement(By.xpath("//input[@id='mark_grade_text_1']")).sendKeys(map.get("grade"));
	driver.findElement(By.xpath("//h3[.='Add eMarks Range & Grade']/../..//button[@id='btnSubmit1']")).click();

	






	}

}
