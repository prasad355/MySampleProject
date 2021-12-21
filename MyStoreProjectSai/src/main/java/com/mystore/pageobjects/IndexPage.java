package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actions1;
import com.mystore.base.BaseClass1;


public class IndexPage extends BaseClass1 {
	@FindBy (xpath= "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy (xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy (xpath ="//*[@id='search_query_top']")
	WebElement searchProductBox;
	
	@FindBy (xpath ="//button[@name='submit_search']")
	WebElement searchButton;
	
    public IndexPage() {
    	PageFactory.initElements(driver,this);
    
    }
    public LoginPage clickOnSignIn() {
    	Actions1.click(driver, signInBtn);
    	return new LoginPage();
    	
    }
    public boolean validateLogo() {
    	return Actions1.isDisplayed(driver, myStoreLogo);
    }
    public String getMyStoreTitle() {
    	String myStoreTitle1=driver.getTitle();
    	return myStoreTitle1;
    }
     public SearchResultPage searchProduct( String productName) {
    	 Actions1.type(searchProductBox, productName);
    	 Actions1.click(driver, searchButton);
    	 return new SearchResultPage();
     }
    
}
