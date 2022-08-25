package com.example.nufarm_expert_mobile.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Login {
	
	private AndroidDriver<MobileElement> driver;
	
	public Login(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	By phone = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
	By btnNext = By.xpath("//android.widget.Button[@content-desc=\"Selanjutnya\"]");
	By password = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
	By btnMasuk = By.xpath("//android.widget.Button[@content-desc=\"Masuk\"]");
	By btnProfile = By.xpath("//android.widget.ImageView[@content-desc=\"Profile\"]");
	By btnKeluar = By.xpath("//android.widget.Button[@content-desc=\"Keluar\"]");
	By greet = By.xpath("//android.view.View[@content-desc=\"Selamat Pagi, \r\n"
			+ "beki\"]");
	
	public void logout() {
		driver.findElement(btnProfile).click();
		delay(3);
		driver.findElement(btnKeluar).click();
		delay(1);
		driver.findElement(btnKeluar).click();
	}
	
	public String getTextGreeting() {
		return driver.findElement(greet).getText();
	}
	
	public String getTextActivity() {
		return driver.currentActivity();
	}
	
	
	
	public void validLogin() {
		delay(3);
		driver.findElement(phone).click();
		driver.getKeyboard().sendKeys("081223456789");
		driver.hideKeyboard();
		driver.findElement(btnNext).click();
		delay(3);
		driver.findElement(password).click();
		driver.getKeyboard().sendKeys("SssOoo*01");
		driver.hideKeyboard();
		driver.findElement(btnMasuk).click();
	}
	
	public void invalidNumber() {
		delay(3);
		driver.findElement(phone).click();
		driver.getKeyboard().sendKeys("0809899999");
		driver.hideKeyboard();
		driver.findElement(btnNext).click();
		delay(3);
	}
	
	static void delay(int seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
