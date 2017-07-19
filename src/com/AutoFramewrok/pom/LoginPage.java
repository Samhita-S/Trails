package com.AutoFramewrok.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	@FindBy(id="username")
	private WebElement unTXB;
	
	@FindBy(name="pwd")
	private WebElement pwTX;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//span[@class='errormsg']")
	private WebElement errmsg;
	
	@FindBy(xpath="//nobr[Contains(text(),'actiTIME')]")
	private WebElement actiTimeversion;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
	}
    public void setUsername(String un){
    	unTXB.sendKeys(un);
    }
    
    public void setPassword(String pw){
    	pwTX.sendKeys(pw);
    }
    
    public void clickLogin(){
    	loginBtn.click();
    }
    public void verifyerrmsgIsDisaplyed(){
    	verifyElementIspresent(errmsg);
    }
    public String getVersion(){
    	return actiTimeversion.getText();
    }
    
    
}
