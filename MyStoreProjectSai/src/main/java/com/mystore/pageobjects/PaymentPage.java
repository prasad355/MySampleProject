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
public class PaymentPage extends BaseClass1{
	@FindBy(xpath ="//a[@class='bankwire']")
	WebElement bankWireMethood;
	
	@FindBy(xpath ="//a[@class='cheque']")
	WebElement chequeMethood;
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	public OrderSummary clickOnPaymentMethod() {
		Actions1.click(driver, bankWireMethood);
		return new OrderSummary();
	}


}
