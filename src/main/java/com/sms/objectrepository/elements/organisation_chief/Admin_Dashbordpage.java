package com.sms.objectrepository.elements.organisation_chief;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Java_Utility;
import com.commonutilities.genericutilities.Wait_Utilities;

public class Admin_Dashbordpage
{
	WebDriver driver ;

	@FindBy(xpath="//span[.='Teacher']") private WebElement teachertab;
	@FindBy(xpath="//a[@href='all_teacher.php']") private WebElement allteacheroption;
	@FindBy(xpath="//span[.='Subject']") private WebElement subjecttab;
	@FindBy(xpath="//span[.='Ingenious Developer1']") private WebElement adminsignouticon;
	@FindBy(xpath="//a[.='Sign out']") private WebElement adminsignoutbtn;
	@FindBy(xpath="//span[.='My Profile']") private WebElement adminprofiletab;
	@FindBy(xpath="//span[.='Student']") private WebElement studenttab;
	@FindBy(xpath="//a[.=' Add Student']") private WebElement addstudenttab;
	@FindBy(xpath="//span[.='Student Payment']") private WebElement studentpaymenttab;
	public Admin_Dashbordpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickteacher_selectallteacher(Java_Utility javautility) 
	{		
		teachertab.click();
		javautility.pausewebaction(2000);
		allteacheroption.click();
	}
	public void subjecttabclick()
	{
		subjecttab.click();
	}
	public void adminsignout()
	{
		adminsignouticon.click();
		adminsignoutbtn.click();
	}
	public void clickonmyprofiletab()
	{
		adminprofiletab.click();
	}
	public void clickonstudentand_addstudent()
	{
		studenttab.click();
		addstudenttab.click();
	}
	public void clickonstudentpaymenttab()
	{
		studentpaymenttab.click();
	}

}
