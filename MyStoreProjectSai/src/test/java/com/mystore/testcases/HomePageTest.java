package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass1;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass1 {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;

	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();

       }
	@Test(groups = "smoke")
	public void wiishlistTest() {
		indexpage= new IndexPage();
		loginpage =indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result=homepage.validateMyWishlist();
		Assert.assertTrue(result);
		
	}
	@Test(groups = "smoke")
	public void orderHistoryandDetailsTest() {
		indexpage= new IndexPage();
		loginpage =indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result=homepage.validateOrderHistory();
		Assert.assertTrue(result);
		
	}
}
