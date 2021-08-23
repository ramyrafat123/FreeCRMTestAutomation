package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
//	PageFactor - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[2]/a")
	WebElement SignUpBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/div[1]/a")
	WebElement crmLogo;

//	Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//	Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();	
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	

}
