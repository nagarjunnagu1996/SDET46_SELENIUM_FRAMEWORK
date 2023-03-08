package edu.growlife.organisation_chief;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Format;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adding_Grade_Student_Teacher {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String sheetname="Adminmodule";
		String test_scripname="Adding_Grade_Student_Teacher";
		Map<String, String> map=new HashedMap<>();
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook wbook = WorkbookFactory.create(fis);
		Sheet sheet = wbook.getSheet(sheetname);
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
		System.out.println(url1);


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,10);
		driver.get(url1);
		String loginpage_text=driver.findElement(By.xpath("//h4[.='User Login...!']")).getText();
		Thread.sleep(2000);
		System.out.println("login page is displayed");
		String username = prop.getProperty("ausername");
		String password = prop.getProperty("apassword");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();


		String admindasboardtext=driver.findElement(By.xpath("//strong[normalize-space(.)='Ingenious']")).getText();
		Thread.sleep(2000);
		if(admindasboardtext.equals(map.get("act_admin_dashb_text")))
		{
			System.out.println("addmin ddashboard page is displayed");

		}
		else
		{
			System.out.println("addmin dashboard page is not displayed");
		}
		driver.findElement(By.xpath("//span[.='Grade']")).click();
		String currenturl=driver.getCurrentUrl();
		if(currenturl.contains(map.get("grade_pagetext")))
		{
			System.out.println("grade preview page is displayed");
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(map.get("garde"));
			driver.findElement(By.xpath("//input[@id='admission_fee']")).sendKeys(map.get("admission_fee"));
			driver.findElement(By.xpath("//input[@id='hall_charge']")).sendKeys(map.get("hall_fee"));
			driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		}
		else
		{
			System.out.println("grade preview page is not displayed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='mark_range_text_1']")).sendKeys(map.get("grade_range"));
		driver.findElement(By.xpath("//input[@id='mark_grade_text_1']")).sendKeys(map.get("grade"));
		driver.findElement(By.xpath("//h3[.='Add eMarks Range & Grade']/../..//button[@id='btnSubmit1']")).click();
	}

}
