package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: ramy rafat')]")
	WebElement userNameLable;

	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/a")
	WebElement contactLink;
	
	@FindBy(xpath="//td[contains(text(),'New Contacts')]")
	WebElement newContactLink;

	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[5]/a")
	WebElement dealLink;	

	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[6]/a")
	WebElement taskLink;

	//	Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();	
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
		
	}

	public ContactsPage clickOnContactLink() {
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealLink() {
		dealLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskLink() {
		taskLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContact() {

		Actions action =new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		

}
}