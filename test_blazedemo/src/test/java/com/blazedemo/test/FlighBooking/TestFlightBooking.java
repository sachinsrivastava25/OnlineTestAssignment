package com.blazedemo.test.FlighBooking;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.utils.BasePage;
import com.blazedemo.base.utils.BaseTest;
import com.blazedemo.page.FlightBooking.Blazedemo;

public class TestFlightBooking extends BaseTest
{
	@BeforeMethod
	public void login() throws InterruptedException
	{
		launchFoxApplication();
		
		
	}
	
	@Test
	public void flightBooking() throws Exception
	{
		final Blazedemo blazedemo = getInstanceOfWebPages(Blazedemo.class);
		blazedemo.chooseDepartureCity("Portland");
		blazedemo.chooseDestinationCity("Dublin");
		blazedemo.findFligh();
		blazedemo.selectFlight("United Airlines");
		blazedemo.flyerDetails("Sachin", "BTM", "BLORE", "KA", "560076", "1111111111", "Sachin");
		blazedemo.flightPurchase();
		String id = blazedemo.getBookingId();
		System.out.println("Booking id: " + id);
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
}
