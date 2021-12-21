package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass1;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass1{
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
	@Test(dataProvider = "credentials", dataProviderClass= DataProviders.class, groups = {"Smoke", "Sanity"})
	public void loginTest(String uname, String pswd) {
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		Log.info("user is going to click on signin");
		loginpage =indexpage.clickOnSignIn();
		Log.info("enter username and password");
		//homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage= loginpage.login(uname, pswd);
		String actualUrl= homepage.getCurrUrl();
		String expectedUrl ="http://automationpractice.com/index.php?controller=my-account";
		Log.info("verify if user is able to login");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("login is scuccess");
		Log.endTestCase("loginTest");
		
	}
}
