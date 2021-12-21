package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actions1;
import com.mystore.base.BaseClass1;

public class AddToCartPage extends BaseClass1{
	@FindBy (xpath = "//input[@id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy (xpath = "//select[@id='group_1']")
	WebElement size;
	
	@FindBy (xpath = "//span[normalize-space()='Add to cart']")
	WebElement addTOCartBtn;
	@FindBy (xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addToCartMessage;
	@FindBy (xpath = "//span[contains (text(),'Proceed to checkout')]")
	WebElement Checkoutbtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	public void enterQuantity(String quantity1) {
		Actions1.type(quantity, quantity1);
	}
	public void selectSize (String size1) {
		Actions1.selectByVisibleText(size1, size);
	}
	public void clickOnAddToCart() {
		Actions1.click(driver, addTOCartBtn);
	}
	public boolean validateAddToCart() {
		Actions1.fluentWait(driver, addToCartMessage, 10);
		
		return Actions1.isDisplayed(driver, addToCartMessage);	
	}
	
	
	
	 public OrderPage clickOnCheckOut() {
		 Actions1.fluentWait(driver, Checkoutbtn, 10);
		 Actions1.JSClick(driver, Checkoutbtn);
		
	
		 return new OrderPage();
	 }
	
	

}
