package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.commonutilities.genericutilities.Selenium_utility;
import com.commonutilities.webactionsutility.Javascript_Utilities;

public class launchbrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Selenium_utility sc=new Selenium_utility();
WebDriver driver=sc.launchbrowser("chrome");
sc.maximizebrowser();
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.location=arguments[0]","https://facebook.com");
WebElement uname = driver.findElement(By.xpath("//input[@id='email']"));
//css editor
js.executeScript("arguments[0].setAttribute('style','border:solid;');",uname);
	}

}
