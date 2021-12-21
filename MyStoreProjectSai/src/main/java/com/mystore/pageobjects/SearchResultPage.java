package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actions1;
import com.mystore.base.BaseClass1;

public class SearchResultPage extends BaseClass1 {
	@FindBy (xpath = "//*[@id='center_column']//img")
			WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean isProductAvailable() {
		return Actions1.isDisplayed(driver, productResult);
	}
	public AddToCartPage clickOnProduct() {
		Actions1.click(driver, productResult);
		return new AddToCartPage();
	}
	
}
