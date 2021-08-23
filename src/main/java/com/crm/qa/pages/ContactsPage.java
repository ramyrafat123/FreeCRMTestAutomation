package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(name="client_lookup")
	WebElement saveBtn;
	
	public ContactsPage() {
	PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		
		return contactsLable.isDisplayed();
		
	}
	public void selectContacts(String name) {
		
		driver.findElement(By.xpath("+name+")).click();
		
	}
	public void createNewContact(String title, String ftName , String ltName ,String comp) {
		
		Select select =new Select(driver.findElement(By.name("title")));
		select.deselectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	

}
