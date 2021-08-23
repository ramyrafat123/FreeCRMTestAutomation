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

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	TasksPage taskspage;
	DealsPage dealspage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		taskspage=new TasksPage();
		dealspage=new DealsPage();
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		
		String HomePageTitle =homepage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactLinkTest() {
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactLink();
		
	}
	@Test(priority = 4)
	public void verifyTasksLinkTest() {
		testutil.switchToFrame();
		taskspage=homepage.clickOnTaskLink();
		
	}
	@Test(priority = 5)
	public void verifyDealsLinkTest() {
		testutil.switchToFrame();
		dealspage=homepage.clickOnDealLink();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
	
	
}
