package com.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	//public WebDriver driver;
	/**
	 * This method is used to initialize the threadLoacal driver on the basis of given browser
	 * @param browser
	 * @return This will return tlDriver
	 */
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); 
	
	public WebDriver int_driver(String browser) {
				
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			
		}
		
		else if(browser.equalsIgnoreCase("Internet Explorer")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		
		else {
			System.out.println("Please pass the correct browser value: "+ browser);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
		
		
	}
	
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
		
	}
	
}
