package com.facebbok.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.facebook.testbase.TestBase;

public class Facebook_Home extends TestBase{
	
	//locators
	By profileTab = By.xpath("//*[@title='Profile']");
	By freindsTab = By.xpath("//*[@data-tab-key='friends']");
	By individualFriends = By.xpath("//div[@class='fsl fwb fcb']");
	
	public Facebook_Home(WebDriver _driver){
		this.driver = _driver;
	}
	
	public void clickProfileTab(){
		driver.findElement(profileTab).click();
	}
	
	public void clickFreindsTab() throws InterruptedException{
		driver.findElement(freindsTab).click();
		
		while(true){
			List<WebElement> freindsListBeforeScrolling = driver.findElements(individualFriends);
			System.out.println("Num of friends: " + freindsListBeforeScrolling.size());
			
			System.out.println("------------- ");
			
			for(WebElement elem : freindsListBeforeScrolling){
				System.out.println(elem.getText());
			}
			
			JavascriptExecutor  js = (JavascriptExecutor) driver;		
			js.executeScript("window.scrollBy(0, 1000)");
			Thread.sleep(4000);
			
			List<WebElement> freindsListAfterScrolling = driver.findElements(individualFriends);		
			if(freindsListBeforeScrolling.size() == freindsListAfterScrolling.size()) break;
		}
	}

	

}
