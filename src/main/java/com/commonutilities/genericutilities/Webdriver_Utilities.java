package com.commonutilities.genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

public class Webdriver_Utilities
{
	WebDriver driver=new ChromeDriver();
	//for maximize the window
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	//implicitly wait
	public void waitforpageload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, null);
	}
	//to wait until clickable of element
	public void waitforelementtobeclickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//to wait until visibility of element
	public void waitforelementtobevisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//handle dropdown by visible text
	public void selectbyvisibletext(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	//handle dropdown by index
	public void selectbyindex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	//handle dropdown by value
	public void selectbyvalue(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	//handle dropdown by deselect by index
	public void deselectbyindex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	//handle dropdown by deselect by value
	public void deselectbyvalue(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.deselectByValue(value);
	}
	//handle dropdown by deselect by visible text
	public void deselectbyvisibletext(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.deselectByVisibleText(text);
	}
	//to perform mouse over action
	public void mouseoveraction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();		
	}
	//to perform mouse over action by offset
	public void mouseoveractionbyoffset(WebDriver driver,WebElement element,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element, x, y).perform();
	}
	//to perform double click action
	public void doubleclick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	//to perform right click action
	public void rightclick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	//to perform drag and drop action
	public void draganddrop(WebDriver driver,WebElement from,WebElement to)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to).perform();		
	}
	//to perform drag and drop action by offset
	public void draganddropbyoffset(WebDriver driver,WebElement element,int x, int y)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(element, x, y).perform();		
	}
	//to switch to frame by index
	public void switchtoframebyindex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	//to switch to frame by address of the element
	public void switchtoframebyaddress(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	//to switch default frame
	public void switchtodefaultframe(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	//scrolldown action upto 1000pixel
	public void scrollupto100(WebDriver driver,int Fromvalue,int Tovalue)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(Fromvalue,Tovalue)");
	}

	//scrolldown action to soecified element
	public void scrolltospecifiedelement(WebDriver driver,WebElement element,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int X=element.getLocation().getX();
		int Y=element.getLocation().getY();
		js.executeScript("window.scrollBy("+X+","+Y+")");
	}

	//to get title of the page
	public String getpagetitle(WebDriver driver,String title)
	{
		title=driver.getTitle();
		return title;
	}
	//to get current url of the page
	public String getcurrenturlofpage(WebDriver driver,String url)
	{
		url=driver.getCurrentUrl();
		return url;
	}
	// to close the tab
	public void closetab(WebDriver driver)
	{
		driver.close();
	}
	// to quite
	public void quitetab(WebDriver driver)
	{
		driver.quit();
	}
	// to quite
	public String getpagesource(WebDriver driver,String source)
	{
		source=driver.getPageSource();
		return source;
	}
	// to get location of the element
	public int getlocation(WebDriver driver,WebElement element)
	{
		int X=element.getLocation().getX();
		int Y=element.getLocation().getY();
		return Y;
		
	}
	//accept alert window popup
	public void acceptalertpopup(WebDriver driver) 
	{
	driver.switchTo().alert().accept();	
	}
	//accept alert window popup
	public void dismissalertpopup(WebDriver driver) 
	{
	driver.switchTo().alert().dismiss();	
	}
	//dismiss alert window popup
	public void sendkeystoalertpopup(WebDriver driver,String value) 
	{
	driver.switchTo().alert().sendKeys(value);;	
	}
	//gettext from alert window popup
	public String gettextfromalertpopup(WebDriver driver) 
	{
	String text = driver.switchTo().alert().getText();
	return text;
	}
	//Handle hidden popup
	public void hiddenpopuphandle(WebDriver driver ,WebElement xpath,String value)
	{
		driver.findElement(By.xpath("xpath")).sendKeys(value);
	}
	// to get page source
	public String getpagesource(WebDriver driver)
	{
		String source=driver.getPageSource();
		 return source;
	}
	//to take screenshot
	public void takescreenshot(WebDriver driver,String filename) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot"+filename+".png");
		FileUtils.copyDirectory(src, dst);
	}
	
}