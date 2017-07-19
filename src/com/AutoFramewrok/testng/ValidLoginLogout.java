package com.AutoFramewrok.testng;

import org.testng.annotations.Test;

import com.AutoFramewrok.pom.EnterTimeTrackPage;
import com.AutoFramewrok.pom.LoginPage;

import Generics.UtilityLib;

public class ValidLoginLogout extends BaseTest {
	@Test(priority=1)
	public void testValidLoginLogout() throws InterruptedException{
		String un = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pwd=UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 1);
		String hp=UtilityLib.getCellValue(INPUT_PATH,"ValidLoginLogout", 1, 2);
		String lp=UtilityLib.getCellValue(INPUT_PATH,"ValidLoginLogout", 1, 3);
		
		LoginPage l = new LoginPage(driver);
		l.verifyTitle(lp);
		l.setUsername(un);
		l.setPassword(pwd);
		l.clickLogin();
		Thread.sleep(1000);
		EnterTimeTrackPage e= new EnterTimeTrackPage(driver);
		e.verifyTitle(hp);
		e.clickLogout();
		Thread.sleep(1000);
		l.verifyTitle(lp);
		
	}

}
