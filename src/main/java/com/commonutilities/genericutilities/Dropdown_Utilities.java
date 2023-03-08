package com.commonutilities.genericutilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Utilities
{
	/**
	 * handle dropdown by visible text
	 * @param element
	 * @param text
	 */
		public void handledropdown(String text,WebElement element)
		{
			Select sel=new Select(element);
			sel.selectByVisibleText(text);
		}
		/**
		 * handle dropdown by index
		 * @param element
		 * @param index
		 */
		public void handledropdown(WebElement element,int index)
		{
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		/**
		 * handle dropdown by value
		 * @param element
		 * @param value
		 */
		public void handledropdown(WebElement element,String value)
		{
			Select sel=new Select(element);
			sel.selectByValue(value);
		}
		/**
		 * handle dropdown by deselect by index
		 * @param element
		 * @param index
		 */
		public void deselectbyindex(WebElement element,int index)
		{
			Select sel=new Select(element);
			sel.deselectByIndex(index);
		}
		/**
		 * handle dropdown by deselect by value
		 * @param element
		 * @param value
		 */
		public void deselectbyvalue(WebElement element,String value)
		{
			Select sel=new Select(element);
			sel.deselectByValue(value);
		}
		/**
		 * handle dropdown by deselect by visible text
		 * @param element
		 * @param text
		 */
		public void deselectbyvisibletext(WebElement element,String text)
		{
			Select sel=new Select(element);
			sel.deselectByVisibleText(text);
		}
		/**
		 * this function is used to deselct all options
		 * @param element
		 */
		public void deselectalloptions(WebElement element)
		{
			Select sel=new Select(element);
			sel.deselectAll();
		}
		/**
		 * this method is used to fetch all options present in dropdown
		 * @param element
		 * @return
		 */
		public List<WebElement> getalloptions(WebElement element)
		{
			Select sel=new Select(element);
			return sel.getOptions();
		}
}
