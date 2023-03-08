package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.commonutilities.webactionsutility.Javascript_Utilities;
import com.github.dockerjava.api.model.Driver;

public class heighlightelement {

	public static void main(String[] args) throws IOException, InterruptedException
	{

		Propertyfile_Utilitiesnew proputility =new Propertyfile_Utilitiesnew(Framework_Constatnts.PROPERTY_FILE_PATH);
		Selenium_utility selutility=new Selenium_utility();

	WebDriver driver=selutility.launchbrowser("chrome");
	Javascript_Utilities jsutility=new Javascript_Utilities( driver);
	selutility.maximizebrowser();
	selutility.launchapplication(proputility.getpropertyfiledata(propertkeys.URL));
	WebElement uname = driver.findElement(By.xpath("//input[@id='email']"));
	Thread.sleep(6000);
	jsutility.highlightelement(uname);
	}

}
