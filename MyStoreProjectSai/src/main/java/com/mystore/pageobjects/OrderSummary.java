package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actions1;
import com.mystore.base.BaseClass1;

public class OrderSummary extends BaseClass1 {
	@FindBy(xpath = "//span[text()='I confirm my order']")
	WebElement confirmOrderBtn;
	public OrderSummary() {
		PageFactory.initElements(driver, this);
    }
	
	
	public OrderComformationPage clickonComfirmOrder() {
		Actions1.click(driver, confirmOrderBtn);
		return new OrderComformationPage();
	}
}
