package com.qa.PassionateTeaSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {

	@FindBy(id = "wsb-canvas-template-page")
	private WebElement browseAllItems;
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	private WebElement greenTeaCheckOut; 
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451959280\"]/span")
	private WebElement redTeaCheckOut; 
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451961556\"]/span")
	private WebElement oolongTeaCheckOut;

	public WebElement getBrowseAllItems() {
		return browseAllItems;
	}

	public void setBrowseAllItems(WebElement browseAllItems) {
		this.browseAllItems = browseAllItems;
	} 
	
	public void clickCheckout(String whichTea)
	{
		if(whichTea == "green tea")
		{
			greenTeaCheckOut.click();
		}
		if(whichTea == "red tea")
		{
			redTeaCheckOut.click(); 
		}
		if(whichTea == "oolang tea")
		{
			oolongTeaCheckOut.click(); 
		}
	}
	
//	public void inputText(String item1, String item2, String item3)
//	{
//		
//	}
	
}
