package com.testing.commerceTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.testing.Helpers.BrowserFactory;
import com.testing.PageClasses.*;

import junit.framework.Assert;


public class RegisterPageTest {
	
	public static Properties property;
	Faker faker = new Faker();
	
	@Test (priority=1)
	public void registerUser() {
		 property = new Properties();
		
		 
			try {
				InputStream inputStream = new FileInputStream("E:\\Projects\\commerceTest\\src\\test\\java\\com\\testing\\test_config.properties");
				property.load(inputStream);
				inputStream.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}

		String FName = property.getProperty("fname")+faker.random().nextInt(1000);
		String LName = property.getProperty("lname")+faker.random().nextInt(1000);
		String dd = property.getProperty("day");
		String mm = property.getProperty("month");
		String yy = property.getProperty("year");
		String emails = property.getProperty("email")+faker.random().nextInt(1000)+"@gmail.com";
		String company = property.getProperty("company")+faker.random().nextInt(1000);
		String pwd = property.getProperty("pwd")+faker.random().nextInt(1000);
		
		
		 WebDriver driver = BrowserFactory.startBrowser("chrome","https://demo.nopcommerce.com/");
		  RegisterPage register_page = PageFactory.initElements(driver, RegisterPage.class);
		  register_page.clickRegisterLink();
		  register_page.SelectGender();
		  register_page.EnterFirstName(FName);
		  register_page.EnterLastName(LName);
		  register_page.SelectDay(dd);
		  register_page.SelectMonth(mm);
		  register_page.SelectYear(yy);
		  register_page.EnterMail(emails);
		  register_page.ScrolltoCompany();
		  register_page.EnterCompany(company);
		  register_page.EnterPassword(pwd);
		  register_page.EnterCPassword(pwd);
		  register_page.ClickRegisterbtn();
		 String rverify= driver.findElement(By.xpath("//div[@class='result']")).getText();
		 String expectedval ="Your registration completed";
		 Assert.assertEquals(expectedval, rverify);
		 try {
				OutputStream outputStream = new FileOutputStream("E:\\Projects\\commerceTest\\src\\test\\java\\com\\testing\\test_config.properties");
				property.setProperty("luname", emails);
				property.setProperty("lpwd", pwd);
				property.store(outputStream, null);
				outputStream.close();

			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		 driver.quit();
	}
	
	

}
