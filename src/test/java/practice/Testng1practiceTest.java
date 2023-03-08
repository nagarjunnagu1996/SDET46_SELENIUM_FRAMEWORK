package practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;

public class Testng1practiceTest
{
	WebDriver driver;
	Selenium_utility selutility=new Selenium_utility();
	Propertyfile_Utilitiesnew proper=new Propertyfile_Utilitiesnew();
	Loginpage loginp=new Loginpage(driver);


	@Test(groups = "sanity")
	public void test1()
	{
		selutility.launchapplication("");
		loginp.loginaction("admin@gmail.com", "12345");
		System.out.println("class2 and test1");
	}
	/*@Test(groups = "regression")
	public void test2()
	{
		System.out.println("class2 and test2");
	}
	@Test
	public void test3()
	{
		System.out.println("class2 and test3");
	}
*/
}
