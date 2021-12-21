/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actions1;
import com.mystore.base.BaseClass1;

/**
 * @author prasad
 *
 */
public class LoginPage extends BaseClass1 {
	@FindBy (xpath="//input[@id='email']" )
	WebElement userName;
	@FindBy (xpath="//input[@id='passwd']" )
	WebElement userPasword;
	@FindBy (xpath="//button[@id='SubmitLogin']" )
	WebElement signInBtn;
	@FindBy (xpath="//input[@id='email_create']" )
	WebElement emailForNewAccount;
	@FindBy (xpath="//button[@id='SubmitCreate']" )
	WebElement createAccountbtn;	
	
	 public LoginPage() {
	    	PageFactory.initElements(driver,this);
	 }
	 public HomePage login(String uname , String pswd) {
		 Actions1.type(userName, uname);
		 Actions1.type(userPasword, pswd);
		 Actions1.click(driver, signInBtn);
		 return new HomePage();
	 }
	 public AdressPage login1(String uname , String pswd) {
		 Actions1.type(userName, uname);
		 Actions1.type(userPasword, pswd);
		 Actions1.click(driver, signInBtn);
		 return new AdressPage();
	 }
	 public AccountCreationPage createNewAccount(String newEmail) {
		 Actions1.type(emailForNewAccount, newEmail);
		 Actions1.click(driver, createAccountbtn);
		 return new AccountCreationPage();
	 }
	
	}
	    



