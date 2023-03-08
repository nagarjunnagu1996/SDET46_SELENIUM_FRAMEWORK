package com.sms.objectrepository.elements.organisation_chief;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Wait_Utilities;

public class subjectpreviewpage 
{
	@FindBy(id="name") private WebElement subjecttextfield;
	@FindBy(xpath="//button[.='Submit']")  private WebElement subjectsubmitbtn;
	@FindBy(xpath="//div[@id='insert_Success']//div[@class='modal-header bg-primary']") private WebElement scussmsg;
	public subjectpreviewpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void entersubnameandsubmit(Wait_Utilities waitutility,WebDriver driver, String subname)
	{
	subjecttextfield.sendKeys(subname);
	subjectsubmitbtn.click();
	waitutility.waitforinvisibility(driver, 10, scussmsg);
	}
}
