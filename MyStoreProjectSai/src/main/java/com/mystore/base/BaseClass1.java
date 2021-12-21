package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {

	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

//	@BeforeTest(groups= {"Smoke","Sanity","Regression"})
//	public void loadConfig() {
//		try {
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream(
//					System.getProperty("user.dir") + "\\Configuration\\config.properties");
//			prop.load(ip);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
    
	public void launchApp( String browserName) {

		WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get(prop.getProperty("url"));
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
