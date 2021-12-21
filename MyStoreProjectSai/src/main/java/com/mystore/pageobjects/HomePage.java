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
 * @author prasa
 *
 */
public class HomePage extends BaseClass1 {
	@FindBy (xpath ="//span[text() ='My wishlists']")
	WebElement myWhistList;
	@FindBy (xpath = "//span[text() ='Order history and details']")
	WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	
	}
	public boolean validateMyWishlist() {
		return Actions1.isDisplayed(driver, myWhistList);
	}
	public boolean validateOrderHistory() {
		return Actions1.isDisplayed(driver, orderHistory);
	}
	public String getCurrUrl() {
		String homePageUrl=driver.getCurrentUrl();	
	     return homePageUrl;
	}

}
