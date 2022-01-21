package com.applicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driver.factory.DriverFactory;
import com.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private WebDriver driver;
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
	}
	
	@Before(order=1)
	public void launchBrowser() {
		
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.int_driver(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void takesScreenshot(Scenario scenario) {
		String screenshotName = scenario.getName().replace(" ", "_");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		byte[] sourcePath = screenshot.getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/jpg", screenshotName);
	}

	
}
