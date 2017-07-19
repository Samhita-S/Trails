package com.AutoFramewrok.testng;

import org.testng.annotations.Test;

import com.AutoFramewrok.pom.LoginPage;

import Generics.UtilityLib;

public class InvalidLogin extends BaseTest{
	@Test(priority=2)
	public void testInvalidLogin() throws InterruptedException{
	
		int rc=UtilityLib.getRowCount(INPUT_PATH, "InvaildLogin");
		System.out.println(rc);
		for(int i=1;i<=rc;i++){
			String un = UtilityLib.getCellValue(INPUT_PATH, "InvaildLogin", i, 0);
			String pwd=UtilityLib.getCellValue(INPUT_PATH, "InvaildLogin", i, 1);
			LoginPage l = new LoginPage(driver);
			l.setUsername(un);
			l.setPassword(pwd);
			l.clickLogin();
			Thread.sleep(1000);
			l.verifyerrmsgIsDisaplyed();
		}
	}

}
