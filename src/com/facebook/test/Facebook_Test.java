package com.facebook.test;

import org.testng.annotations.Test;
import com.facebook.testbase.TestBase;

public class Facebook_Test extends TestBase{
	
	@Test
	public void TestFacebookFriends()  throws InterruptedException{
		flogin.loginFacebook("type your email", "type your password");
		fhome.clickProfileTab();
		fhome.clickFreindsTab();
	}

}
