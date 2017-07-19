package com.AutoFramewrok.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage extends BasePage {
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	final String x1="//div[@class='popup_menu_icon warning_icon']";
	@FindBy(xpath=x1)
	private WebElement settings;
	
	@FindBy(linkText="Licenses")
	private WebElement license;

	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);

	}
	public void clickLogout(){
		logout.click();
	}

	public void clicksettings(){
		settings.click();
	}
	public void clickLicenses(){
		license.click();
	}
}
