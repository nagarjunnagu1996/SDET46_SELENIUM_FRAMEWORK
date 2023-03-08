package com.commonutilities.genericutilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Utilities
{
	WebDriverWait wait;
	/**
	 * this method is used to wait explicitly
	 * @param driver
	 * @param timeout
	 */
	public void initialixeconditionalwait(WebDriver driver,long timeout)
	{
		wait=new WebDriverWait(driver, timeout);
	}
	/**
	 * this method is used to wait until visible of element in the web page
	 * @param element
	 */
	public void waitforvisibility(WebDriver driver,long timeout,WebElement element)
	{
		wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	/**
	 *  this method is used to wait until to click the element in the web page
	 * @param element
	 */
	public void waitfortoclickelement(WebDriver driver,long timeout,WebElement element)
	{
		wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	/**
	 *  this method is used to wait implicitly
	 * @param driver
	 * @param timeout
	 */
	public void waitforpageload(WebDriver driver,long timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	/**
	 * this method is used to wait until visible of element in the web page
	 * @param element
	 */
	public void waitforinvisibility(WebDriver driver,long timeout,WebElement element)
	{
		wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));	
	}
	public void verifloginypage(WebDriver driver)
	{
		String url=driver.getCurrentUrl();
		if(url.contains("Student_Management_System"))
		{
			System.out.println("login page is displayed");
		}
		else
		{
			System.out.println("login page is not displayed");
		}
	}
	/**
	 * this method is used to acheive custom wait
	 * @param element
	 * @param duration
	 * @param pollingtime
	 * @throws InterruptedException
	 */
	public void waituntillclick(WebElement element,int duration,long pollingtime) throws InterruptedException
	{
		int count=0;
		while(count<duration)
		{
			try {
				element.click();
				break;
			} 
			catch (Exception e) 
			{

				Thread.sleep(pollingtime);
				count++;
			} 
		}
	}
}


