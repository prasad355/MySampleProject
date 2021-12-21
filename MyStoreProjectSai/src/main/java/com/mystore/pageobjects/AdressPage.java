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
public class AdressPage extends BaseClass1 {
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement ProceedToCheckOutbtn;
	public AdressPage() {
		PageFactory.initElements(driver, this);
    }
	public boolean CheckOutButton() {
		return Actions1.isDisplayed(driver, ProceedToCheckOutbtn);
	}
	public ShippingPage clickOnCheckOut() {
		Actions1.click(driver, ProceedToCheckOutbtn);
		return new ShippingPage();
	}

}
