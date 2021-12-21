package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actions1;
import com.mystore.base.BaseClass1;

public class OrderPage extends BaseClass1 {
	
	@FindBy (xpath ="//span[contains(text(),'$16.51')]")
	WebElement unitPrice ;
	
	@FindBy (xpath ="//span[@id='total_price']")
	WebElement totalPrice ;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement ProceedToCheckOut;
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	public double getUnitPrice() {
	String unitPrice1 =unitPrice.getText();
	String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
	double finalUnitPrice =Double.parseDouble(unit);
	return finalUnitPrice/100;
	}
	public double getTotalPrice() {
		String totalPrice1 =unitPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice =Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	public LoginPage clickONCheckOut() {
		Actions1.click(driver, ProceedToCheckOut);
		return new LoginPage();
	}
	

}
