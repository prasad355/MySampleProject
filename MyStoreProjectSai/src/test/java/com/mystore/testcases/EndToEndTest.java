package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass1;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AdressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderComformationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest  extends BaseClass1{
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage addtocart;
	OrderPage orderpage;
	LoginPage loginpage;
	AdressPage adresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummary ordersummary;
	OrderComformationPage ordercmppage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	@Test(groups = "Regression")
	public void verifyTotalPrice() {
		index = new IndexPage();
		 
		searchresultpage=index.searchProduct("t-shirts");
		addtocart=searchresultpage.clickOnProduct();
		
		addtocart.enterQuantity("2");
		addtocart.selectSize("M");
		addtocart.clickOnAddToCart();
		orderpage =addtocart.clickOnCheckOut();
		loginpage=orderpage.clickONCheckOut();
		adresspage=loginpage.login1(prop.getProperty("username"),prop.getProperty("password"));
		shippingpage =adresspage.clickOnCheckOut();
		shippingpage.checkTheTerms();
		paymentpage=shippingpage.clickOnProceedToCheckOut();
		ordersummary=paymentpage.clickOnPaymentMethod();
		 ordercmppage=ordersummary.clickonComfirmOrder();
		String actualMessage= ordercmppage.validateConfirmMessage();
		String expectedmsg= "Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedmsg);
		
	}
	

}
