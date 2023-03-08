package com.sms.objectrepository.elements.organisation_chief;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.enumsutility.tabnames;

public class Commonpage_Elements 
{
	WebDriver driver;
String partialxpath="//span[.='%s']";//span[.='My Profile']
private WebElement convertTobelement(String partialxpath,String replacedata)
{
	String xpath = String.format(partialxpath, replacedata);
	return driver.findElement(By.xpath(xpath));
}
public Commonpage_Elements(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void  clicktab( tabnames tab)
{
	convertTobelement(partialxpath,tab.gettabnames()).click();
	
}
}
