package com.testing.PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver wdriver) {
		this.driver= wdriver;	
		PageFactory.initElements(driver, this);
		}
	@FindBy(how=How.XPATH,using="//a[@class='ico-login']")
	WebElement LoginLink;
	@FindBy(how=How.ID,using="Email")
	WebElement EmailId;
	@FindBy(how=How.ID,using="Password")
	WebElement Password;
	@FindBy(how=How.XPATH,using="//button[@class='button-1 login-button']")
	WebElement LoginBtn;
	@FindBy(how=How.XPATH,using="//a[@class='ico-logout']")
	WebElement logoutBtnElement;
	@FindBy(how=How.XPATH,using="//span[@id='Email-error']")
	WebElement emailError;
	@FindBy(how=How.XPATH,using="//div[@class='message-error validation-summary-errors']//ul/li")
	WebElement loginError;
	@FindBy(how=How.CLASS_NAME,using="ico-account")
	WebElement MyAccount;
	@FindBy(how=How.ID,using="gender-female")
	 WebElement SelectFeMaleGender;
	@FindBy(how=How.ID,using="save-info-button")
	WebElement SaveBtn;
	@FindBy(how=How.CLASS_NAME,using="close")
	WebElement SpanClose;
	
	
	//click on Login link
	public void ClickLoginLink() {
		LoginLink.click();
	}
	// Enter User name
	public void EnterUserName(String username) {
		EmailId.sendKeys(username);
	}
	//Enter password
	public void EnterPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	//click on login button
	public void clickLoginbtn() {
		LoginBtn.click();
	}
	// click on logout button
	public void clickLogoutbtn() {
		logoutBtnElement.click();
	}
	// verifing whether logout button is displaying or not.
	public boolean displaylogoutbtn() {
		return logoutBtnElement.isDisplayed();
	}
	// verifying whether error messsage displaying in email
	public boolean displayemailError() {
		return emailError.isDisplayed();
	}
	// verifying the text of email error
	public String getTextEmailError() {
		return emailError.getText();
	}
	// get text of login error
	public String getTextLoginError() {
		return loginError.getText();
	}
	public void ClickMyAccount() {
		MyAccount.click();
	}
	 // Select gender male
	 public void SelectGender() {
		 SelectFeMaleGender.click();
	 }
	 // Scroll to view save button
	public void ScrolltoSaveBtn() {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		}
	public void ClickSaveBtn() {
		SaveBtn.click();
	}
	public void CloseSpan() {
		SpanClose.click();
	}
	public void ScrolltoLogoutBtn() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", logoutBtnElement);
	}
	
	public void IsClickableElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ico-logout")));
		logoutBtnElement.click();
	}
		
}
