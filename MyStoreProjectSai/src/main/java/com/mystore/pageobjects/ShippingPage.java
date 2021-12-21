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
public class ShippingPage extends BaseClass1 {
	@FindBy (xpath = "//*[@id=\"cgv\"]")
	WebElement clickOnCheckBox;
	@FindBy (xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedTOCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	public void checkTheTerms() {
		Actions1.click(driver, clickOnCheckBox);
	}
	public PaymentPage clickOnProceedToCheckOut() {
		Actions1.click(driver, proceedTOCheckOutBtn);
		return new PaymentPage();
	}

}
