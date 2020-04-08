package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends BaseTest{

	@AndroidFindBy (xpath = "//*[contains(@content-desc,'search')]") private MobileElement searchIcon;

	public SearchPage waitForSearchIcon() { 
		waitforVisibility(searchIcon); 
		return this; 
		}


	public SearchEntryPage pressSearchIcon() {
		click(searchIcon);
		//returns back to the same page
		return new SearchEntryPage();
	}


}
