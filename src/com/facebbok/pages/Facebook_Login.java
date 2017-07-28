package com.facebbok.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.testbase.TestBase;

public class Facebook_Login extends TestBase{
	
	//locators
	By username = By.id("email");
	By password = By.id("pass");
	By login = By.id("u_0_r");
	
	public Facebook_Login(WebDriver _driver){
		this.driver = _driver;
	}
	
	public void loginFacebook(String usr, String pass){
		driver.findElement(username).sendKeys(usr);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click(); 
	}

} //end Facebook_Login
