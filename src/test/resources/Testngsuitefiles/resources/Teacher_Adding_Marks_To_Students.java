import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teacher_Adding_Marks_To_Students
{
	public static void main(String[] args) throws IOException 
	{
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			 WebDriverWait wait=new WebDriverWait(driver,10);
				FileInputStream fis=new FileInputStream("./src/test/resources/common_data/commondata.properties");
				Properties prop = new Properties();
				prop.load(fis);
				String url1 = prop.getProperty("url");
			driver.get(url1);
			String username = prop.getProperty("tusername");
			String password = prop.getProperty("tpassword");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
			driver.findElement(By.xpath("//span[.='Exam']")).click();
			driver.findElement(By.xpath("//a[@href='my_student_exam_marks.php']")).click();
			WebElement gradedropd = driver.findElement(By.xpath("//select[@id='grade']"));
			Select sel=new Select(gradedropd);
			sel.selectByIndex(1);
			WebElement examdropd=driver.findElement(By.xpath("//select[@id='exam']"));
			Select sel2=new Select(examdropd);
			sel2.selectByVisibleText("java1");
			driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
			driver.findElement(By.xpath("//a[.='cherry g']/../../td[3]/a[1]")).click();
			WebElement mathsub = driver.findElement(By.xpath("//input[@type='text']"));
			mathsub.clear();
			String mathsmark = prop.getProperty("mathsmarks");
			mathsub.sendKeys(mathsmark);
			driver.findElement(By.xpath("//button[@id='btnSubmit3']")).click();
			driver.findElement(By.xpath("(//a[@class=' btn btn-primary btn-xs'])[1]")).click();


		}
}
