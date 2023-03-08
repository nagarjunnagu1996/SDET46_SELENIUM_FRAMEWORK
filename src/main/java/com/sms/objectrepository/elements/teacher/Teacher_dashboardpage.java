package com.sms.objectrepository.elements.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Dropdown_Utilities;

public class Teacher_dashboardpage 
{
@FindBy(xpath="//span[.='My Profile']") private WebElement profiletab;
@FindBy(xpath="//span[.='Exam']") private WebElement examtab;
@FindBy(xpath="//a[@href='my_student_exam_marks.php']") private WebElement mystdmarkstab;
@FindBy(xpath="//img[@class='user-image']") private WebElement teachersignouticon;
@FindBy(xpath="//a[.='Sign out']") private WebElement teachersignoutbtn;


	
	public Teacher_dashboardpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void teacher_profileclick()
	{
		profiletab.click();	
	}
	public void clickexamtab_clickmystdmarkstab()
	{
		examtab.click();
		mystdmarkstab.click();
	}
	public void teachersignout()
	{
		teachersignouticon.click();
		teachersignoutbtn.click();
	}
}
