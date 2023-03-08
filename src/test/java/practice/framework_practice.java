package practice;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.commonutilities.enumsutility.excelsheet;
import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.ExcelUtilitiesnew;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Java_Utility;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.commonutilities.genericutilities.Wait_Utilities;

public class framework_practice {

	public static void main(String[] args) throws IOException 
	{
		
		Propertyfile_Utilitiesnew properutil=new Propertyfile_Utilitiesnew(Framework_Constatnts.PROPERTY_FILE_PATH);
		ExcelUtilitiesnew excelutils = new ExcelUtilitiesnew(Framework_Constatnts.EXCEL_FILE_PATH);
		Selenium_utility selutility=new Selenium_utility();
		Wait_Utilities waitutility=new Wait_Utilities();
		Java_Utility javautility=new Java_Utility();
		String ausername = properutil.getpropertyfiledata(propertkeys.AUSERNAME);
		String apassward = properutil.getpropertyfiledata(propertkeys.APASSWORD);

		String sheetname = excelsheet.ADMINMODULE.getsheetname();
		System.out.println(sheetname);
		String exptestscript="add_student_login_as_parent_and_see_profile";
		Map<String, String> map = excelutils.getdata(sheetname, exptestscript);
		System.out.println(map);
		System.out.println(properutil.getpropertyfiledata(propertkeys.URL));

		WebDriver driver=selutility.launchbrowser("chrome");
		selutility.maximizebrowser();
		selutility.launchapplication(properutil.getpropertyfiledata(propertkeys.URL));
		driver.findElement(By.id("email")).sendKeys(javautility.decodestring(properutil.getpropertyfiledata(propertkeys.APASSWORD)));
		driver.findElement(By.id("password")).sendKeys(apassward);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		driver.findElement(By.xpath("//span[.='My Profile']")).click();
		driver.findElement(By.xpath("//span[.='Student']")).click();
		driver.findElement(By.xpath("//a[.=' Add Student']")).click();
		driver.findElement(By.xpath("//span[.='Student Payment']")).click();
		driver.findElement(By.xpath("//input[@id='index_number']")).sendKeys(map.get("index_number"));
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		//waitutility.waitexplicit(driver, 10);
	
		waitutility.waitfortoclickelement( driver.findElement(By.xpath("//h4[.='B kempegowda']/..//span[@class='glyphicon glyphicon-remove']")));
		driver.findElement(By.xpath("//span[.='Ingenious Developer1']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		waitutility.waitforpageload(driver, 10);
		driver.findElement(By.id("email")).sendKeys(properutil.getpropertyfiledata(propertkeys.PUSERNAME));
		driver.findElement(By.id("password")).sendKeys(properutil.getpropertyfiledata(propertkeys.PPASSWORD));
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		driver.findElement(By.xpath("//span[.='Subject']")).click();
		driver.findElement(By.xpath("//span[.='Timetable']")).click();
		driver.findElement(By.xpath("//span[.='Attendance']")).click();
		driver.findElement(By.xpath("//a[@href='my_sons_attendance.php']")).click();
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		javautility.consoleprint("test case is pass");
	}

}
