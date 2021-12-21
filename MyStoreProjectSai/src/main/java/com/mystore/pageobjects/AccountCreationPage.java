/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.mystore.actiongetgetDriver.Actions1;
import com.mystore.base.BaseClass1;

/**
 * @author prasa
 *
 */
public class AccountCreationPage  extends BaseClass1{
	@FindBy (xpath = "//h1[text()='Create an account']")
	WebElement formTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean validateAccountCreatePage() {
		//return Actions1.isDisplayed(getDriver(), formTitle);
		return com.mystore.actiondriver.Actions1.isDisplayed(driver, formTitle);
	}
	public void validateAccount() {
	
	}

}
