package com.sms.objectrepository.elements.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Dropdown_Utilities;
import com.commonutilities.genericutilities.Wait_Utilities;

public class exampreviewpage 
{
	@FindBy(xpath="//select[@id='grade']") private WebElement gradedropdown;
	@FindBy(xpath="//select[@id='exam']") private WebElement examdropdown;
	public exampreviewpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void selectgrade(Dropdown_Utilities drop,int index)
	{
		drop.handledropdown(gradedropdown, index);
	}
	public void selectexam( Dropdown_Utilities drop,String text)
	{
		
		drop.handledropdown( text, examdropdown);
	}
	
}
