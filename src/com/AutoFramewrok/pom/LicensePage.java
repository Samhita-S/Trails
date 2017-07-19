package com.AutoFramewrok.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LicensePage extends BasePage{
	
	final String x2="//b[contains(text(),'actiTIME')]";
	@FindBy(xpath=x2)
	private WebElement productEdition;

	public LicensePage(WebDriver driver) {
		super(driver);
		}
	
	public void verifyProductEdition(String evalue){
		String avalue=productEdition.getText();
		Assert.assertEquals(avalue, evalue);
		}
}
