package com.commonutilities.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Interactions_Utilities 
{
	WebDriver driver;
	Actions act=new Actions(driver);
	/**
	 * this method is used to mouse over action on element
	 * @param element
	 */
	public void mouseoveraction(WebElement element)
	{

		act.moveToElement(element).perform();		
	}
	/**
	 * this method is used to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebElement element)
	{
		act.doubleClick(element);
	}
	/**
	 * this method is used to double click on the web page
	 */
	public void doubleclick()
	{
		act.doubleClick();
	}
	/**
	 * using this functionwe can perform right click action on element
	 * @param driver
	 * @param element
	 */
	public void rightclick(WebElement element)
	{
		act.contextClick(element);
	}
	/**
	 * using this functionwe can perform right click action on web page
	 * @param element
	 */
	public void rightclick()
	{

		act.contextClick();
	}
	/**
	 * we can perform drag and drop action by this function
	 * @param from
	 * @param to
	 */
	public void draganddrop(WebElement from,WebElement to)
	{
		act.dragAndDrop(from, to).perform();		
	}
	/**
	 * to perform drag and drop action by offset
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void draganddropbyoffset(WebElement element,int x, int y)
	{
		act.dragAndDropBy(element, x, y).perform();		
	}
}
