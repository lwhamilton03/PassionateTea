package com.qa.PassionateTeaSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	WebDriver driver = null;
	public ExtentReports report; 
	public ExtentTest test; 
	
	
	
	
	@Before 
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", Constants.chromeDrive);
		driver = new ChromeDriver(); 
		
		report = new ExtentReports(Constants.reportFilePath, false);
		
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() 
	{
	    driver.get(Constants.home); 
	    
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() 
	{
		test = report.startTest("Step1");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		test.log(LogStatus.INFO, "Click Menu");
		home.clickMenu();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() 
	{
		test.log(LogStatus.INFO, "Browse Items");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		//should I not have the green tea in a format such that 
//		if(menu.getBrowseAllItems().getText().contains("green tea"))
//		{
//			System.out.println(menu.getBrowseAllItems().getText());
//			test.log(LogStatus.PASS, "Browsing Items");
//		}
//		else
//		{
//			System.out.println("no tea");
//			test.log(LogStatus.FAIL, "Not Browsing Items");
//		}
		assertEquals("Can't Browse Items", "green tea", menu.getBrowseAllItems().getText());
	}

	private void assertEquals(String string, String string2, String text) {
		// TODO Auto-generated method stub
		
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() 
	{
		//Is there a better way to check all the different combinations of the tea class that you want 
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickMenu();
		
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() 
	{
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickCheckout("green tea");
		assertEquals("Not Taken To The Checkout Page", Constants.checkoutTitle, driver.getTitle());
	}
	
	
	@After
	public void tearDown()
	{
		
		
		report.endTest(test);
		
		report.flush();
		
		driver.quit();
	}
		
}
