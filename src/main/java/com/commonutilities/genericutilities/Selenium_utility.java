package com.commonutilities.genericutilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.commonutilities.enumsutility.propertkeys;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * in this class all selenium webdriver utilities are present
 * @author nagarjuna m
 *
 */
public class Selenium_utility {
WebDriver driver=null;
	/**
	 * this method is used to launch the browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchbrowser(String browser)
	{
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			default:
				System.out.println("enter proper browser");
		}
		return driver;
	}
	/**
	 * this method is used to maximize the browser
	 */
	public void maximizebrowser()
	{
		
		driver.manage().window().maximize();
	}
	/**
	 * this function is used to launch the application by passing the url
	 * @param url
	 * @return 
	 */
	public WebDriver launchapplication(String url)
	{
		driver.get(url);
		return driver;
	}
	/**
	 * this method is used to resize the browser
	 * @param width
	 * @param height
	 */
	public void resizebrowser(int width,int height)
	{
		driver.manage().window().setSize(new Dimension(width, height));
	}
	/**
	 * this method is used to close the particular tab
	 */
	public void closetab()
	{
		driver.close();
	}
	/**
	 * this method is used to c lose the entire browser
	 */
	public void closebrowser()
	{
		driver.quit();
	}
	/**
	 * this method is used to get title of the page
	 * @param driver
	 * @param title
	 * @return
	 */
	public String getpagetitle()
	{
		return driver.getTitle();

	}
	/**
	 * this method is used to get current url of the page
	 * @param driver
	 * @param url
	 * @return
	 */
	public String getcurrenturlofpage()
	{
		return driver.getCurrentUrl();

	}
	/**
	 * this method is used to get screenshot for web browser
	 * @param driver
	 * @param filename
	 * @return 
	 * @throws IOException
	 */
	public String takescreenshot(String testcasename,Calender_Utilities calenderutility) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshots/pages/"+testcasename+"_"+calenderutility.getcurrentdatetime()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	/**
	 * this method is used to take screen shot by using base64
	 * @return
	 */
	public String takescreenshot()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
		
	/**
	 * this method is used to get screenshot for element
	 * @param element
	 * @param elementname
	 * @return
	 * @throws IOException
	 */
	public String getscreenshot(WebElement element,WebElement elementname) throws IOException
	{
		File src = element.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\src\test\resources\screenshots\""+elementname+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void scrolltospecifiedlocation(WebDriver driver,WebElement element,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int X=element.getLocation().getX();
		int Y=element.getLocation().getY();
		js.executeScript("window.scrollBy("+X+","+Y+")");
	}

}
