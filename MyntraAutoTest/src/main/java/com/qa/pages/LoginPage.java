package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest{
	
	/*@AndroidFindBy (xpath = "//*[contains(@content-desc,'search')]") private MobileElement searchIcon;
	@AndroidFindBy (xpath = "//*[contains(@content-desc,'search_default_search_text_input')]") private MobileElement searchBar;

	public LoginPage pressSearchIcon() {
		click(searchIcon);
		//returns back to the same page
		return this;
	}
	
	public LoginPage enterItemName(String itemName) {
		sendKeys(searchBar,itemName );
		//returns back to the same page
		return this;
	}
	
	
	//driver.findElement(By.xpath("//*[contains(@content-desc,'search')]")).click();
	//WebElement searchBar = driver.findElement(By.xpath("//*[contains(@content-desc,'search_default_search_text_input')]"));
	searchBar.click();
	searchBar.sendKeys("Shoes");
	driver.pressKeyCode(AndroidKeyCode.ENTER);
}*/
}