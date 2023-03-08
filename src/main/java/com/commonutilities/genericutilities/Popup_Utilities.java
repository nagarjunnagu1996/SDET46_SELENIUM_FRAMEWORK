package com.commonutilities.genericutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Popup_Utilities 
{
	/**
	 * accept alert window popup
	 * @param driver
	 */
		public void acceptalertpopup(WebDriver driver) 
		{
		driver.switchTo().alert().accept();	
		}
		/**
		 * accept alert window popup
		 * @param driver
		 */
		public void dismissalertpopup(WebDriver driver) 
		{
		driver.switchTo().alert().dismiss();	
		}
		/**
		 * by using this method we can send data to popup text field
		 * @param driver
		 * @param value
		 */
		public void senddatoalertpopup(WebDriver driver,String value) 
		{
		driver.switchTo().alert().sendKeys(value);;	
		}
		/**
		 * gettext from alert window popup
		 * @param driver
		 * @return
		 */
		public String gettextfromalertpopup(WebDriver driver) 
		{
		String text = driver.switchTo().alert().getText();
		return text;
		}
		/**
		 * by using this method we can Handle hidden popup by sending the value/path of the file
		 * @param driver
		 * @param xpath
		 * @param value
		 */
		public void hiddenpopuphandle(WebDriver driver ,String xpath,String value)
		{
			driver.findElement(By.xpath("xpath")).sendKeys(value);
		}
		
}
