package com.facebook.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.facebbok.pages.Facebook_Home;
import com.facebbok.pages.Facebook_Login;
import com.facebook.config.Config;

public class TestBase {
	
	protected WebDriver driver;
	protected Facebook_Login flogin;
	protected Facebook_Home fhome;
	private String url = Config.URL;
	private String browser = Config.BROWSER;	
			
	@BeforeMethod 
	public void SetUp(){
		getWebDriver();
		navigatetoPage();
		applyTimeOuts();
		createPageObjects();
	}
		
	@AfterMethod
	public void tearDown(){
		try{
			driver.quit();
		}catch(Exception ex){
			System.out.println("Exception: " + ex);
		}		
	}
	
	private void createPageObjects() {
		fhome = new Facebook_Home(driver);	
		flogin = new Facebook_Login(driver);		
	}

	private void applyTimeOuts() {
		driver.manage().timeouts().pageLoadTimeout(Config.PAGELOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT, TimeUnit.SECONDS);		
	}

	private void navigatetoPage() {
		driver.navigate().to(url);
		driver.manage().window().maximize();		
	}

	private void getWebDriver() {
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver = new FirefoxDriver();
		}		
	}

	

}
