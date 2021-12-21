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
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass1 {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	SearchResultPage searchresult;
	
	
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
	public void productAvailabilityTest()  {
		indexpage = new IndexPage();
//		loginpage =indexpage.clickOnSignIn();
//		homepage=loginpage.login(prop.getProperty("username"), ("password"));
	     searchresult =indexpage.searchProduct("t-shirts");
	    boolean result= searchresult.isProductAvailable();
	    Assert.assertTrue(result);
		
	
		
	}


}
