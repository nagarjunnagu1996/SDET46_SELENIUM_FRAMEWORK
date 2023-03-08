package com.sms.objectrepository.elements.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Wait_Utilities;

public class mystudent_exampage 
{
	@FindBy(xpath="//a[.='cherry g']/../../td[3]/a[1]") private WebElement cherrystd_edit_btn;
	@FindBy(xpath="//input[@type='text']") private WebElement mathsubtextfield;
	@FindBy(xpath="//input[@type='text']") private WebElement sbtbutton;
	@FindBy(xpath="//div[@class='modal-body bgColorWhite']/../../../..//div[@class='modal msk-fade']/following-sibling::div[@id='update_Success']//strong")
	private WebElement successmsg;
	
	



		
		public mystudent_exampage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		public void clickonstd_editbtn()
		{
			cherrystd_edit_btn.click();	
		}
		public void clearmarksand_entermarks(String marks)
		{
			mathsubtextfield.clear();
			mathsubtextfield.sendKeys(marks);
		}
		public void sbtbuttonafter_exammarksentered()
		{
			sbtbutton.click();
		}
		public void handlemsg_popup(Wait_Utilities waitutility,WebDriver driver, int timeout)
		{
			waitutility.waitforinvisibility(driver, timeout, successmsg);
		}
		
		
}
