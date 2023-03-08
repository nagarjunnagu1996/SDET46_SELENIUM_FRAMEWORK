package com.sms.objectrepository.elements.organisation_chief;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Wait_Utilities;

public class Student_Paymentpage
{
	@FindBy(xpath="//input[@id='index_number']") private WebElement indexnumber_textfield;
	@FindBy(xpath="//button[@id='btnSubmit']") private WebElement submitbtn;
	@FindBy(xpath="//h4[.='B kempegowda']/..//span[@class='glyphicon glyphicon-remove']") private WebElement parentdetailspopupremove;
	
	public Student_Paymentpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterdatato_indextextfield(String indexnum)
	{
		indexnumber_textfield.sendKeys(indexnum);
		submitbtn.click();
	}
	public void removeparentdetailspopup(Wait_Utilities waitutiity,long timeout,WebDriver driver)
	{
		waitutiity.waitfortoclickelement(driver, 20, parentdetailspopupremove);	
	
	}
}
