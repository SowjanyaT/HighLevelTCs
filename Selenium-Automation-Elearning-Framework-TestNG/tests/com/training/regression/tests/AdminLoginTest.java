package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginTest {
	public WebDriver driver;
	private String baseUrl;
	public AdminCategoryPOM admincategoryPOM;
	private  Properties properties;
	private  ScreenShot screenShot; 
    
    
	@BeforeTest
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		admincategoryPOM = new AdminCategoryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		Thread.sleep(3000);
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);
	}

/*	@BeforeMethod
	public void setUp() throws Exception {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		admincategoryPOM = new AdminCategoryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);
		
	}
*/
	
	

	@Test(priority=1)
	public void Adminlogin() throws InterruptedException {
	admincategoryPOM.sendusername("admin");
	
	admincategoryPOM.sendPassword("admin@123");
	Thread.sleep(3000);
	admincategoryPOM.clickLoginBtn();
	screenShot.captureScreenShot();
	Thread.sleep(3000);
	
	}
}
