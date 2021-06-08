package com.blazedemo.base.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.page.FlightBooking.Blazedemo;

public class BaseTest{
	
	private BasePage basePage;
	private WebDriver driver;
	private Blazedemo blazedemo;
	
	public void launchFoxApplication() throws InterruptedException {
		final String driverPath = System.getProperty("user.dir") + File.separator + "driver" + File.separator
                + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://blazedemo.com/");
	    BasePage.log("Launched ");
	    BasePage.log("Environment : " );
	  }
	
	public BasePage getBasePage() {
	    if (basePage == null) {
	      basePage = new BasePage(getDriver());
	    }
	    return basePage;
	  }	
	
	public WebDriver getDriver() {
	    return driver;
	  }

	// JAVA Generics to Create and return a New Page
	  public <TPage extends BasePage> TPage getInstanceOfWebPages(Class<TPage> pageClass) throws Exception {
	    try {
	      // Initialize the Page with its elements and return it.
	      return PageFactory.initElements(driver, pageClass);
	    } catch (final Exception e) {
	      e.printStackTrace();
	      throw e;
	    }
	  }
}
