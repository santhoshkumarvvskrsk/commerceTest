package com.testing.PageClasses;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage  {
	

	WebDriver driver;
	public RegisterPage(WebDriver wdriver) {
		this.driver= wdriver;	
		PageFactory.initElements(driver, this);
		}
	
	 @FindBy(how=How.XPATH,using="//a[@class='ico-register']")
	 WebElement RegisterLink;
	 @FindBy(how=How.ID,using="gender-male")
	 WebElement SelectMaleGender;
	 @FindBy(how=How.ID,using="gender-female")
	 WebElement SelectFemaleGender;
	 @FindBy(how=How.ID,using="FirstName")
	 WebElement FirstName;
	 @FindBy(how=How.ID,using="LastName")
	 WebElement LastName;
	 @FindBy(how=How.NAME,using="DateOfBirthDay")
	 WebElement day;
	 @FindBy(how=How.NAME,using="DateOfBirthMonth")
	 WebElement month;
	 @FindBy(how=How.NAME,using="DateOfBirthYear")
	 WebElement year;
	 @FindBy(how=How.ID,using="Email")
	 WebElement mailid;
	 @FindBy(how=How.ID,using="Company")
	 WebElement companies;
	 @FindBy(how=How.ID,using="Password")
	 WebElement pwd;
	 @FindBy(how=How.ID,using="ConfirmPassword")
	 WebElement cpwd;
	 @FindBy(how=How.ID,using="register-button")
	 WebElement registerbtn;
	 
	 //click on Register link
	 public void clickRegisterLink() {
		 RegisterLink.click();
	 }
	 // Select gender male
	 public void SelectGender() {
		 SelectMaleGender.click();
	 }
	 // Enter First name
	public void EnterFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	// Enter Last Name
	public void EnterLastName(String lname) {
		LastName.sendKeys(lname);
	}
	// Select Day
	public void SelectDay(String dayval) {
		Select daydropdown = new Select(day);
		daydropdown.selectByValue(dayval);
	}
	// Select Month
	public void SelectMonth(String mon) {
		Select monthdropdown = new Select(month);
		monthdropdown.selectByValue(mon);
	}
	// Select month
	public void SelectYear(String yy) {
		Select yeardropdown = new Select(year);
		yeardropdown.selectByValue(yy);
	}
	// Enter mail
	public void EnterMail(String mail) {
		mailid.sendKeys(mail);
	}
	// Scroll to view company field.
	public void ScrolltoCompany() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", companies);
	}
	// Enter value in company
	public void EnterCompany(String cc) {
		companies.sendKeys(cc);
	}
	// Enter Password
	public void EnterPassword(String pwds) {
		pwd.sendKeys(pwds);
	}
	// Enter confirm password
	public void EnterCPassword(String cpwds) {
		cpwd.sendKeys(cpwds);
	}
	// click on registeration link
	public void ClickRegisterbtn() {
		registerbtn.click();
	}
}
