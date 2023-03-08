package com.sms.objectrepository.elements.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Teacher_Profilepage
{
@FindBy(xpath="//h4[@id='hname']") private WebElement tnameinprofile;
	
	public Teacher_Profilepage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public String teacher_profilename()
	{
		String name = tnameinprofile.getText();	
		return name;
		
	}
}
