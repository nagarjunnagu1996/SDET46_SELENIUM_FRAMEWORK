package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class fetch_data_fromdb_and_create_project_in_rmgyantra {

	public static void main(String[] args) throws InterruptedException, SQLException 
	{
		String project_name="grow_life3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		Connection conne=null;

		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Projects']")))).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//h4[.='Create Project']/../following-sibling::div//input[@name='projectName']")).sendKeys(project_name);
		driver.findElement(By.xpath("//h4[.='Create Project']/../following-sibling::div//input[@name='createdBy']")).sendKeys("arjun3");
		WebElement statusdrop = driver.findElement(By.xpath("//h4[.='Create Project']/../following-sibling::div/div//select"));
		Select sel=new Select(statusdrop);
		Thread.sleep(2000);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		Thread.sleep(2000);

		String proj_name = driver.findElement(By.xpath("//th[.='ProjectName']/../../..//tbody/tr//td[.='"+ project_name +"']")).getText();
		if(proj_name.equals(proj_name))
		{
			System.out.println("project is present");
		}
		else
		{
			System.out.println("the project is not present");
		}



		try {
			conne = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = conne.createStatement();
			ResultSet res = state.executeQuery("select * from project where created_by='arjun3'");
			while(res.next())
			{
				String created = res.getString("created_by");
				String projectid = res.getString("project_id");
				String created_date = res.getString("created_on");
				String status = res.getString("status");
				String tsize = res.getString("team_size");
				System.out.println(created+"  "+projectid+"    "+created_date+"    "+status+"    "+tsize);
			}
		}
		finally {
			conne.close();
			System.out.println("database is closed");

		}

	}

}
