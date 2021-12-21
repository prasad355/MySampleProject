package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actions1;
import com.mystore.base.BaseClass1;

public class OrderComformationPage extends BaseClass1 {
	@FindBy (xpath ="//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmMessage;
	public OrderComformationPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessage.getText();
		return confirmMsg;
	}

}
