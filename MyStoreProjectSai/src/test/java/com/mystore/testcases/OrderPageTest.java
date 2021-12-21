package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass1;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass1 {
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage addtocart;
	OrderPage orderpage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	@Test(groups = "Regression", dataProvider="productdetails",dataProviderClass= DataProviders.class)
	public void verifyTotalPrice(String productname, String qty, String size) {
		Log.startTestCase("verify total price ");
		index = new IndexPage();
		 
		searchresultpage=index.searchProduct(productname);
		addtocart=searchresultpage.clickOnProduct();
		
		addtocart.enterQuantity(qty);
		addtocart.selectSize(size);
		addtocart.clickOnAddToCart();
		orderpage =addtocart.clickOnCheckOut();
		double unitPrice=orderpage.getUnitPrice();
		double totalPrice=orderpage.getTotalPrice();
		double totalExpectedPrice = (unitPrice*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(totalPrice,  totalExpectedPrice);
		Log.endTestCase("verify total price");
		
		
		
		
	}

}
