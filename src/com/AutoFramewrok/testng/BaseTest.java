package com.AutoFramewrok.testng;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import Generics.FWListener;
import Generics.IAutoconst;
import Generics.UtilityLib;

@Listeners(FWListener.class)
public abstract class BaseTest implements IAutoconst {
	
	public WebDriver driver;
	
	@BeforeSuite
	public void setDriverPath(){
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@Parameters({"node","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(String node ,String browser) throws MalformedURLException{
		URL whichSystem = new URL(node);
		DesiredCapabilities whichBrowser = new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
		driver = new RemoteWebDriver(whichSystem,whichBrowser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String URL = UtilityLib.getPropertyValue(CONFIG_PATH, "URL");
		driver.get(URL);
		
		
		
		
		
		
		
//		driver  = new FirefoxDriver();
//		String url=UtilityLib.getPropertyValue(CONFIG_PATH, "URL");
//		driver.get(url);
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=osNbWfbVDobDuATAmYKwBQ&gws_rd=ssl");
	}
 
	@AfterMethod
	public void CloseApp(){
		driver.quit();
	}
}
