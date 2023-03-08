package com.sms.objectrepository.elements.organisation_chief;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Allteacher_Page 
{
	@FindBy(xpath="//input[@type='search']") private WebElement teachersearchfield;
	@FindBy(xpath="//a[.='Edit']/../../../tr//td//a[text()='Edit']") private WebElement techereditbtn;

	public Allteacher_Page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void teachersearchfield(String teachername)
	{
		teachersearchfield.sendKeys(teachername);
	}
	public void teachereditingbtn()
	{
		techereditbtn.click();
	}
}
