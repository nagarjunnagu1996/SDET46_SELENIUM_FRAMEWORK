package com.commonutilities.webactionsutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * in this class we utilities called javascript utilities
 * @author nagarjuna m
 *
 */
public class Javascript_Utilities 
{
	JavascriptExecutor js;
	public Javascript_Utilities(WebDriver driver)
	{

		js=(JavascriptExecutor)driver;
	}
	/**
	 * by using this method we can scroll to upside
	 */
	public void scrollup()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollheight)");
	}
	/**
	 *  by using this method we can scroll to downside
	 */
	public void scrolldown()
	{
		js.executeScript("window.scrollBy(0,.document.body.scrollheight)");
	}
	/**
	 *  by using this method we can scroll to required element location
	 * @param element
	 */

	public void scrolltoelement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoview()",element);
	}
	/**
	 * by using this we can perform click action on the element
	 * @param element
	 */
	public void clickelement(WebElement element)
	{
		js.executeScript("arguments[0].click()",element);
	}
	/**
	 * by using this we can send the value to the text field
	 * @param element
	 * @param data
	 */
	public void sendkeystoelement(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	/**
	 * by using the method we can launch the browser by passing the url
	 * @param url
	 */
	public void launchapplication(String url)
	{
		js.executeScript("window.location=arguments[0]",url);
	}
	public void highlightelement(WebElement element)
	{
		js.executeScript("arguments[0].setAttribute('style','border:solid;');",element);
	}
}
