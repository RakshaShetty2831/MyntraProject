package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchResultsPage extends BaseTest{

	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"image_image_container\"])[1]/android.widget.ImageView") private MobileElement neededItem;

	public ItemDescPage selectItem() {
		click(neededItem);
		//returns back to the same page
		return new ItemDescPage();
	}

}