package com.testing.commerceTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.Helpers.BrowserFactory;
import com.testing.PageClasses.LoginPage;
import com.testing.PageClasses.RegisterPage;

import junit.framework.Assert;

public class LoginPageTest {
	public static Properties property;
	public LoginPage login_page;
	public WebDriver driver;
	String luname,lpassword;
	
	@BeforeClass
	public void driver_page_init(){
		 driver = BrowserFactory.startBrowser("chrome","https://demo.nopcommerce.com/");
		 login_page = PageFactory.initElements(driver, LoginPage.class);
		 
	}
//	@BeforeTest
//	public void driver_clickLink() {
////		 driver = BrowserFactory.startBrowser("chrome","https://demo.nopcommerce.com/");
////		 login_page = PageFactory.initElements(driver, LoginPage.class);
////		login_page.ClickLoginLink();
//	}

	@Test (priority=1)
	public void LoginCommerce() {
		 property = new Properties();
		 login_page.ClickLoginLink();
			try {
				InputStream inputStream = new FileInputStream("E:\\Projects\\commerceTest\\src\\test\\java\\com\\testing\\test_config.properties");
				property.load(inputStream);
				inputStream.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			 luname = property.getProperty("luname");
			 lpassword = property.getProperty("lpwd");
			System.out.println(luname + "=====" + lpassword);
//		WebDriver driver = BrowserFactory.startBrowser("chrome","https://demo.nopcommerce.com/");
//		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.EnterUserName(luname);
		login_page.EnterPassword(lpassword);
		login_page.clickLoginbtn();
		Assert.assertEquals(login_page.displaylogoutbtn(),true);
//		if(login_page.displaylogoutbtn()) {
//			login_page.clickLogoutbtn();
//		}		
//		driver.quit();
	}
	@Test (priority=2)
	public void updateGenderAfterLogin() {
		login_page.ClickMyAccount();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login_page.SelectGender();
		login_page.ScrolltoSaveBtn();
		login_page.ClickSaveBtn();
		login_page.CloseSpan();
		login_page.ScrolltoSaveBtn();
		login_page.ScrolltoLogoutBtn();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login_page.IsClickableElement();
//		login_page.clickLogoutbtn();
		
	}
	@Test (priority=3)
	public void loginwithoutCredentials() {
		login_page.ClickLoginLink();
		login_page.clickLoginbtn();
		System.out.println(login_page.displayemailError());
		Assert.assertEquals(login_page.displayemailError(),true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals("Please enter your email",login_page.getTextEmailError());
//		driver.quit();
	}
	@Test (priority=4)
	public void loginwithonlyEmail() {
		
		login_page.ClickLoginLink();
		login_page.clickLoginbtn();
		login_page.EnterUserName(luname);
		login_page.clickLoginbtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ar = login_page.getTextLoginError();
		String er ="The credentials provided are incorrect";
		System.out.println(ar);
		System.out.println(er);
		Assert.assertEquals(er,ar);
//		driver.quit();
	}
	
	@Test(priority=5)
	public void loginwithInvalidUser() {
		
		login_page.ClickLoginLink();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login_page.clickLoginbtn();
		login_page.EnterUserName("sss@gmail.com");
		login_page.clickLoginbtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ers ="No customer account found";
		String ars = login_page.getTextLoginError();
			System.out.println(ars);
		System.out.println(ers);
		Assert.assertEquals(ers,ars);
		driver.quit();
	}
	
	
	
}
