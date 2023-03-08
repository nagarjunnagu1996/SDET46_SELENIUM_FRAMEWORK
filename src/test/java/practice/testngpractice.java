package practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.commonutilities.enumsutility.tabnames;
import com.sms.objectrepository.elements.organisation_chief.Commonpage_Elements;

public class testngpractice
{
	@BeforeSuite
	public void suitesetup()
	{
		System.out.println("before suit");
	}
	@BeforeTest
	public void testsetup()
	{
		System.out.println("Before test");
	}
	@BeforeClass
	public void classsetup()
	{
		System.out.println("Before class");
	}
	@BeforeMethod
	public void methodsetup()
	{
		System.out.println("Before method");
	}
	@Test
	public void testscript()
	{
		System.out.println("test script");
	}
	@AfterMethod
	public void methodteardown()
	{
		System.out.println("after method");
	}
	@AfterClass
	public void classteardown()
	{
		System.out.println("after class");
	}
	@AfterTest
	public void testteardown()
	{
		System.out.println("after test");
	}
	@AfterSuite
	public void suiteteardown()
	{
		System.out.println("after suite");
	}
	

}

