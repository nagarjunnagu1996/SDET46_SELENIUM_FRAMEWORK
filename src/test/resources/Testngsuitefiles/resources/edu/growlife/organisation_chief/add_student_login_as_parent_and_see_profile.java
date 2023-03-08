package edu.growlife.organisation_chief;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Format;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.growlife.utilities.Selenium_utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class add_student_login_as_parent_and_see_profile 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		Selenium_utility selutility=new Selenium_utility();
		String test_scripname="add_student_login_as_parent_and_see_profile";
		Map<String, String> map=new HashedMap<>();
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook wbook = WorkbookFactory.create(fis);
		Sheet sheet = wbook.getSheet("Adminmodule");
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			String tc_name = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(tc_name.equals(test_scripname))
			{
				for(int j=1;j < sheet.getRow(i).getLastCellNum();j++) 
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		FileInputStream fis1=new FileInputStream("./src/test/resources/common_data/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis1);
		String url1 = prop.getProperty("url");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.get(url1);
		String ausern = prop.getProperty("ausername");
		String apassword = prop.getProperty("apassword");
		driver.findElement(By.id("email")).sendKeys(ausern);
		driver.findElement(By.id("password")).sendKeys(apassword);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		driver.findElement(By.xpath("//span[.='My Profile']")).click();
		driver.findElement(By.xpath("//span[.='Student']")).click();
		driver.findElement(By.xpath("//a[.=' Add Student']")).click();
		driver.findElement(By.xpath("//span[.='Student Payment']")).click();
		System.out.println(map.get("index_number"));
		driver.findElement(By.xpath("//input[@id='index_number']")).sendKeys(map.get("index_number"));
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.xpath("//h4[.='B kempegowda']/..//span[@class='glyphicon glyphicon-remove']")))).click();
		driver.findElement(By.xpath("//span[.='Ingenious Developer1']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		String pusername = prop.getProperty("pusername");
		String ppassword = prop.getProperty("ppassword");
		driver.findElement(By.id("email")).sendKeys(pusername);
		driver.findElement(By.id("password")).sendKeys(ppassword);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		driver.findElement(By.xpath("//span[.='Subject']")).click();
		driver.findElement(By.xpath("//span[.='Timetable']")).click();
		driver.findElement(By.xpath("//span[.='Attendance']")).click();

		driver.findElement(By.xpath("//a[@href='my_sons_attendance.php']")).click();
		WebElement fname = driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		String fathrename = fname.getText();
		if(fathrename.equals(map.get("father_name")))
		{
			System.out.println("father profile");
		}
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		System.out.println("test case is pass");

	}

}
