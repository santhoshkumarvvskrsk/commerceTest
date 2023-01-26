package com.testing.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName,String urls) {
		
		if(browserName.equals("firefox")) {
			
			driver = new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();	
		driver.get(urls);
		return driver;
	}
}
