package com.sms.objectrepository.elements.organisation_chief;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonutilities.genericutilities.Wait_Utilities;

public class gradepreview_page
{
	Wait_Utilities waitutility;
	WebDriver driver;
	@FindBy(xpath="//input[@id='name']") private WebElement gradenametextfield;
	@FindBy(xpath="//input[@id='admission_fee']") private WebElement admissionfeetextfield;
	@FindBy(xpath="//input[@id='hall_charge']") private WebElement hallfeetextfield;
	@FindBy(xpath="//button[@id='btnSubmit']") private WebElement submitbtn;

	@FindBy(xpath="//input[@id='mark_range_text_1']") private WebElement graderangetextfield;
	@FindBy(xpath="//input[@id='mark_grade_text_1']") private WebElement gradetextfieldinpopup;
	@FindBy(xpath="//h3[.='Add eMarks Range & Grade']/../..//button[@id='btnSubmit1']") private WebElement submittbtningradepopup;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-plus']") private WebElement addgradebtn;
	@FindBy(xpath="//input[@id='mark_range_text_2']") private WebElement graderangetextfield2;
	@FindBy(xpath="//input[@id='mark_grade_text_2']")  private WebElement gradetextfieldinpopup2;
	@FindBy(xpath="//div[@id='insert_Success']//div[@class='modal-header bg-primary']") private WebElement confirmmsg;
	public gradepreview_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void entergradeanddetails(String gradename,String admissionfee,String hallfees)
	{
		gradenametextfield.sendKeys(gradename);
		admissionfeetextfield.sendKeys(admissionfee);
		hallfeetextfield.sendKeys(hallfees);
		submitbtn.click();
	}
	public void enterrangeand_grade(Wait_Utilities waitutility, WebDriver driver,  String graderange,String grade) 
	{
		//waitutility.initialixeconditionalwait(driver, 20);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graderangetextfield.sendKeys(graderange);	
		gradetextfieldinpopup.sendKeys(grade);
		submittbtningradepopup.click();
		waitutility.waitforinvisibility(driver, 20, confirmmsg);
		
	}
	public void clickaddgradebtn(String graderange2,String gradefieldinpopup2)
	{
		waitutility.waitforinvisibility(driver, 10, graderangetextfield2);
		addgradebtn.click();
		graderangetextfield2.sendKeys(graderange2);
		gradetextfieldinpopup2.sendKeys(gradefieldinpopup2);
		submittbtningradepopup.click();
	}
}
