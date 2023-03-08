package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngpractice2Test 
{

	@BeforeSuite
	public void suitesetup()
	{
		System.out.println("before suit practice2");
	}
	@BeforeTest
	public void testsetup()
	{
		System.out.println("Before test practice2");
	}
	@BeforeClass
	public void classsetup()
	{
		System.out.println("Before class practice2");
	}
	@BeforeMethod
	public void methodsetup()
	{
		System.out.println("Before method practice2");
	}
	@Test
	public void testscript()
	{
		System.out.println("test script practice2");
	}
	@AfterMethod
	public void methodteardown()
	{
		System.out.println("after method practice2");
	}
	@AfterClass
	public void classteardown()
	{
		System.out.println("after class practice2");
	}
	@AfterTest
	public void testteardown()
	{
		System.out.println("after test practice2");
	}
	@AfterSuite
	public void suiteteardown()
	{
		System.out.println("after suite practice2");
	}
	
}
