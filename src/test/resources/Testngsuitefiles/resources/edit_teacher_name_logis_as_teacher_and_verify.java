import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class edit_teacher_name_logis_as_teacher_and_verify 
{
	public static void main(String[] args) throws InterruptedException, IOException 
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
	String username = prop.getProperty("ausername");
	driver.findElement(By.id("email")).sendKeys(username);
	String password = prop.getProperty("apassword");
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
	driver.findElement(By.xpath("//span[.='Teacher']")).click();
	driver.findElement(By.xpath("//a[@href='all_teacher.php']")).click();
	String teacher = prop.getProperty("teachername");
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(teacher);
	driver.findElement(By.xpath("//a[.='Edit']/../../../tr[1]/td[3]/a[1]")).click();
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("headteacher1");
	driver.findElement(By.xpath("//button[@id='btnSubmit1']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[.='Subject']")).click();
	driver.findElement(By.xpath("//span[.='Ingenious Developer1']")).click();
	driver.findElement(By.xpath("//a[.='Sign out']")).click();
	String tusername = prop.getProperty("tusername");
	driver.findElement(By.id("email")).sendKeys(tusername);
	String tpassword = prop.getProperty("tpassword");
	driver.findElement(By.id("password")).sendKeys(tpassword);
	driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
	driver.findElement(By.xpath("//span[.='My Profile']")).click();
	WebElement tname = driver.findElement(By.xpath("//h4[@id='hname']"));
	String tfullname = tname.getText();
	if(tfullname.equals("Teacherr 1fdsfhdfgdh"))
	{
		System.out.println("test case is pass");
	}

	}
}
