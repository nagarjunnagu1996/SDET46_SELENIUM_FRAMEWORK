package com.sms.objectrepository.elements.parent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Wait_Utilities;

public class parent_dashbordpage 
{
	@FindBy(xpath="//span[.='Teacher']") private WebElement teachertab;
	@FindBy(xpath="//span[.='Subject']") private WebElement subjecttab;
	@FindBy(xpath="//span[.='Timetable']") private WebElement timetabletab;
	@FindBy(xpath="//span[.='Attendance']") private WebElement attendancetab;
	@FindBy(xpath="//a[@href='my_sons_attendance.php']") private WebElement mysonsattandancetab;
	@FindBy(xpath="//img[@class='user-image']") private WebElement parentsighnouticon;
	@FindBy(xpath="//a[.='Sign out']") private WebElement psignoutbtn;
	
	
	
	
	public parent_dashbordpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickonteachertab() 
	{
		teachertab.click();
	}
	public void subjecttabclick()
	{
		subjecttab.click();
	}
	public void clickontimetabletab() 
	{
		timetabletab.click();
	}
	public void clickonattendancetab_and_mysonsattendancetab(Wait_Utilities waitutility,WebDriver driver,int timeout)
	{
		attendancetab.click();
		waitutility.waitforpageload(driver,timeout);
		mysonsattandancetab.click();
	}
	public void parentsignout()
	{
		parentsighnouticon.click();
		psignoutbtn.click();
	}
}
