/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass1;
import com.mystore.pageobjects.IndexPage;

/**
 * @author prasa
 *
 */
public class IndexPageTest extends BaseClass1{
	IndexPage indexpage ;
	
	
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
	public void verifyLogo() {
		indexpage = new IndexPage();
		boolean result =indexpage.validateLogo();
		Assert.assertTrue(result);
	}
	@Test(groups = "smoke")
	public void verifyTitle() {
		String actTitle=indexpage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
	}
	

}
