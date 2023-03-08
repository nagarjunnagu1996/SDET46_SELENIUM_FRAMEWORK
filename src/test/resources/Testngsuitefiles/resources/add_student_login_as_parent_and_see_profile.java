import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class add_student_login_as_parent_and_see_profile
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/common_data/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url1 = prop.getProperty("url");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	 WebDriverWait wait=new WebDriverWait(driver, 10);
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
	driver.findElement(By.xpath("//input[@id='index_number']")).sendKeys("25");
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
	if(fathrename.equals("bkempufather"))
	{
		System.out.println("father profile");
	}
	Thread.sleep(5000);
	driver.findElement(By.xpath("//img[@class='user-image']")).click();
	driver.findElement(By.xpath("//a[.='Sign out']")).click();
	System.out.println("test case is pass");

	}

}
