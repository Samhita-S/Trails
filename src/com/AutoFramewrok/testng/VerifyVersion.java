package com.AutoFramewrok.testng;

import org.testng.annotations.Test;

import com.AutoFramewrok.pom.EnterTimeTrackPage;
import com.AutoFramewrok.pom.LicensePage;
import com.AutoFramewrok.pom.LoginPage;

import Generics.UtilityLib;

public class VerifyVersion extends BaseTest{
	@Test(priority=3)
	public void testVerifyVersion() throws InterruptedException{
//		String un = UtilityLib.getCellValue(INPUT_PATH, "VerifyVersion", 1, 0);
//		String pwd=UtilityLib.getCellValue(INPUT_PATH, "VerifyVersion", 1, 1);
		String un = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pwd=UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 1);
		LoginPage l = new LoginPage(driver);
		String version = l.getVersion();
		l.setUsername(un);
		l.setPassword(pwd);
		
		l.clickLogin();
		
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.clicksettings();
		e.clickLicenses();
		
		LicensePage lc=new LicensePage(driver);
		lc.verifyProductEdition(version);
		e.clickLogout();
	}

}
