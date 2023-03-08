package com.sms.objectrepository.elements.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Dropdown_Utilities;

public class mystudentpage 
{

	@FindBy(xpath="//a[@href='my_student.php']") private WebElement mystdbtn;
	@FindBy(xpath="//select[@id='grade']") private WebElement gradedropdown;
	@FindBy(xpath="//button[@class='btn btn-primary']") private WebElement gradesbtbtn;

	public mystudentpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void clickmystdtab()
	{
		mystdbtn.click();
	}
	public void selectgrade(Dropdown_Utilities drop)
	{
	drop.handledropdown(gradedropdown, 1);	
	gradesbtbtn.click();
	}
}
