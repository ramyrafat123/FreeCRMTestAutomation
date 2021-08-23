package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	TasksPage taskspage;
	DealsPage dealspage;

	public ContactPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		//		taskspage=new TasksPage();
		//		dealspage=new DealsPage();
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactLink();
	}
	@Test
	public void verifyContactPageLabel() {
		Assert.assertTrue(contactspage.verifyContactsLabel());
	}
	
	@Test
	public void selectContactsTest() {
		contactspage.selectContacts("test2 test2");
	}
	@Test
	public void selectMultipleContactsTest() {
		contactspage.selectContacts("test2 test2");
		contactspage.selectContacts("test2 test2");

	}
	
	@Test
	private void validateCreateNewContact() {
		homepage.clickOnNewContact();
		contactspage.createNewContact("Mr.", "", "", "");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}



}
