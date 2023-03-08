package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class add_data_into_db_and_verifyin_ui {

	public static void main(String[] args) throws SQLException, InterruptedException 
	{
		Random ra =new Random();
		int random_num = ra.nextInt(1000);
		String project="advancesel"+random_num;
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		Connection conne=null;
		try {
		 conne = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = conne.createStatement();
		int details = state.executeUpdate("insert into project values(103,'arjuna','07/02/2023','"+project+"','Created',0);");
		if(details==1)
		{
			System.out.println("data is inserted successfully");
		}
		}
		finally {
			conne.close();
			System.out.println("databaseis closed");
		}
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Projects']")))).click();
		List<WebElement> allprojects = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/thead/following-sibling::tbody/tr/td[2]"));
	for(WebElement myproj:allprojects)
	{
		String myproject=myproj.getText();
		if(myproject.equals(project))
		{
			System.out.println("project is present");
			break;
		}
		else 
		{
			System.out.println("project is not present");
		}
	}

	}

}
