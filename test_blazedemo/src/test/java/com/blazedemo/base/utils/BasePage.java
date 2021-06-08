package com.blazedemo.base.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class BasePage {
	

	protected WebDriver driver;
	private SoftAssert softAssert;
	public BasePage() {

	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getWebdriver() {
		return driver;
	}
	
	public static void log(String message) {
		Reporter.log(message, true);
	}
	
	public void waitForElementPresent(By locator) {
		final WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public SoftAssert getSoftAssert() {
		softAssert = PageFactory.initElements(getWebdriver(), SoftAssert.class);
		return softAssert;
	}
	
	public void wait(int waitInMS) throws InterruptedException
	{
		Thread.sleep(waitInMS);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void type(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}
	

}
