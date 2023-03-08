package com.sms.objectrepository.elements.organisation_chief;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Teacherpage 
{
@FindBy(xpath="//input[@id='full_name1']") private WebElement nametextfield;
@FindBy(xpath="//button[@id='btnSubmit1']") private WebElement submitbtn;

public Edit_Teacherpage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
public void enterteachernameandsubmit(String newname)
{
	nametextfield.sendKeys(newname);	
	submitbtn.click();
}

}
