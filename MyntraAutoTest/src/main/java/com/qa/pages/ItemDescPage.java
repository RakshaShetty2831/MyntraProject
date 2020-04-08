package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ItemDescPage extends BaseTest{

	@AndroidFindBy (xpath = "//*[contains(@text,'WISHLIST')]") private MobileElement wishListBtn;

	public ItemDescPage selectItem() {
		click(wishListBtn);
		//returns back to the same page
		return this;
	}

}