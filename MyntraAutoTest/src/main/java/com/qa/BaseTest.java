package com.qa;

import org.testng.annotations.Test;

import com.qa.pages.SearchResultsPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	protected static AppiumDriver driver;
	protected static Properties props;
	InputStream inputStream;

	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Passing the TestNG parameter names
	@Parameters({"deviceName","platformName","platformVersion"})
	@BeforeTest
	//Passing Parameters as arguments to beforeTest method
	public void beforeTest(String deviceName, String platformName, String platformVersion	) throws Exception {

		try {
			//Setting the properties file name
			props = new Properties();
			String propFileName = "config.properties";

			//Loading the properties from the config file (Using inputStream because the file is located within the class path, else we would have used FileInputStream)
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);

			//Setting the desired capabilities
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", deviceName);
			caps.setCapability("udid", "c562112f"); //Give Device ID of your mobile phone
			caps.setCapability("platformName", platformName);
			caps.setCapability("platformVersion", platformVersion);
			caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
			caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
			caps.setCapability("noReset", "true");
			caps.setCapability("autoGrantPermissions", true);
			caps.setCapability("clearSystemFiles", true);

			URL url = new URL(props.getProperty("appiumURL"));
			
			driver = new AndroidDriver(url, caps);
			String sessionId = driver.getSessionId().toString();
			//setDriver(driver);
			
			
		} catch(Exception e){
			e.printStackTrace();
			throw e;

		}
	}
	//Creating a method for visibility of an element
	public void waitforVisibility(MobileElement e) {
	 WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
	 wait.until(ExpectedConditions.visibilityOf(e));		
	}

	//Creating a method for click action. This is to check if the element is visible or not. If visible, then only will it click
	public void click(MobileElement e) {
		waitforVisibility(e);
		e.click();
	}

	//Creating a method for sendKeys
	public void sendKeys(MobileElement e , String txt) {
		waitforVisibility(e);
		e.sendKeys(txt);
	}

	//Creating a method for getAttribute action
	public void getAttribute(MobileElement e, String attribute	) {
		waitforVisibility(e);
		e.getAttribute(attribute);
	}

//	public static void setDriver(WebDriver driver) {
//		
//	}
//
//	public static WebDriver getDriver() {
//		return driver;
//		}
//	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
