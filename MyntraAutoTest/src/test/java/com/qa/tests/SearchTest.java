package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.ItemDescPage;
import com.qa.pages.SearchEntryPage;
import com.qa.pages.SearchPage;
import com.qa.pages.SearchResultsPage;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class SearchTest extends BaseTest{


	SearchPage searchPage;
	SearchResultsPage searchResultsPage;
	ItemDescPage itemDescPage;
	SearchEntryPage searchEntryPage;


	/*
	 * @BeforeClass public void beforeClass() { }
	 * 
	 * @AfterClass public void afterClass() { }
	 * 
	 */
	 @BeforeMethod public void beforeMethod(Method m) {
		 searchPage = new SearchPage();
		 System.out.println("\n" + "****Starting Test: " + m.getName() + "****" + "\n");
	  }
	 

	/*
	 * @AfterMethod public void afterMethod() { }
	 */

	@Test
	public void operationSearch()  {
		
		
		searchPage.waitForSearchIcon();
		searchPage.pressSearchIcon();
		searchEntryPage= new SearchEntryPage();
		searchEntryPage = searchPage.pressSearchIcon();
		searchEntryPage.enterItemName("shoes"+Keys.ENTER);
		itemDescPage = searchResultsPage.selectItem();



	}
}


