package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Actions1;
import com.mystore.base.BaseClass1;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartTest extends BaseClass1 {
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage addtocart;
	
	@Parameters("browser")
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest()  {
		index = new IndexPage();
		searchresultpage=index.searchProduct("t-shirts");
		addtocart=searchresultpage.clickOnProduct();
		
		addtocart.enterQuantity("2");
		addtocart.selectSize("M");
		addtocart.clickOnAddToCart();
//		
		boolean result=addtocart.validateAddToCart();
        Assert.assertTrue(result);
        
	}

}
