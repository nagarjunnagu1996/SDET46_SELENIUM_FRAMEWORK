package practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.propertkeys;
import com.commonutilities.genericutilities.Framework_Constatnts;
import com.commonutilities.genericutilities.Propertyfile_Utilitiesnew;
import com.commonutilities.genericutilities.Selenium_utility;
import com.sms.objectrepository.elements.organisation_chief.Loginpage;

public class Testng1practice2Test
{
	WebDriver driver;
	Selenium_utility selutility=new Selenium_utility();
	Propertyfile_Utilitiesnew proper=new Propertyfile_Utilitiesnew(Framework_Constatnts.PROPERTY_FILE_PATH);
	Loginpage loginp=new Loginpage(driver);

	@Test(groups = "smoke")
	public void test1()
	{

		driver=selutility.launchapplication(proper.getpropertyfiledata(propertkeys.URL));
		loginp.loginaction("admin@gmail.com", "12345");

		System.out.println("class3 and test1");
	}
	/*@Test(groups = "integration")
	public void test2()
	{
		System.out.println("class3 and test2");
	}
	@Test(groups = "sanity")
	public void test3()
	{
		System.out.println("class3 and test3");
	}*/

}
