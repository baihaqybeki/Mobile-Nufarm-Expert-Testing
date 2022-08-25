package com.example.nufarm_expert_mobile.testing;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.nufarm_expert_mobile.pages.Login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestLogin {

	private static AndroidDriver<MobileElement> driver;
	private Login login;

	@BeforeClass
	public void setUP() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "RMX1971");
		cap.setCapability("udid", "e381d3a4");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.example.nufarm_expert_mobile");
		cap.setCapability("appActivity", "com.example.nufarm_expert_mobile.MainActivity");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@BeforeMethod
	public void peageObject() {
		login = new Login(driver);
	}

	@Test (priority = 1)
	public void validLogin() {
		login.validLogin();
		String actual = login.getTextGreeting();
		System.out.println(actual);
		System.out.println(login.getTextActivity());
	}

	@Test(priority = 2)
	public void invalidNumber() {
		login.invalidNumber();
		String actual = login.getTextActivity();
		System.out.println(actual);
	}

	@AfterMethod
	public void logout() {
		login.logout();
	}

	@AfterClass
	public void closeApp() {
		driver.quit();
	}

	static void delay(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
