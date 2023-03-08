package com.sms.objectrepository.elements.organisation_chief;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	@FindBy(id="email") private WebElement unametextfield;
	@FindBy(id="password") private WebElement pawdtextfield;
	@FindBy(xpath="//button[@id='btnSubmit']") private WebElement loginbtn;
	
	public Loginpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void loginaction(String username,String password)
	{
		unametextfield.sendKeys(username);
		pawdtextfield.sendKeys(password);
		loginbtn.click();
	}
}

