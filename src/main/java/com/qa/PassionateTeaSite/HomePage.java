package com.qa.PassionateTeaSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menuButton; 

	public void clickMenu()
	{
		menuButton.click();
	}
//	public boolean checkPage(String checkPage)
//	{
//		if(Constants.home == checkPage)
//		{
//			return true; 
//		}
//	return false; 
//	}
	
}
