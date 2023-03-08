package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.commonutilities.genericutilities.TestNGclass;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.growlife.listner.utilities.settestannotationparameter.class)
public class Testng1practice3 extends TestNGclass
{

	@Test(groups = "smoke")
	public void test1()
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		Assert.fail();
		System.out.println("class1 and test1");
	}
	/*@Test(groups = {"regression","minor"})
	public void test2()
	{
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com");
		System.out.println("class1 and test2");
		Assert.fail();
	}
	@Test(groups = "smoke")
	public void test3()
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		driver.get("https://facebook.com");
		System.out.println("class1 and test3");
	}*/

}
