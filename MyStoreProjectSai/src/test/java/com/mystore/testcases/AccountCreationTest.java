package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass1;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationTest extends BaseClass1 {
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreationpage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();

       }
	@Test(dataProvider = "Email", dataProviderClass=DataProviders.class, groups = "Sanity")
	public void accountCreationTest(String mail) {
		indexpage = new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		//accountcreationpage=loginpage.createNewAccount("1243727272@gmail.com");
		accountcreationpage=loginpage.createNewAccount(mail);
		boolean result =accountcreationpage.validateAccountCreatePage();
		Assert.assertTrue(result);
		
	}

}
