package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageElements {
	
	private WebDriver driver;
	
	// By Locators
	private By firstName= By.xpath("//input[@id='first_name']");
	private By lastName = By.cssSelector("input[id='last_name']");
	private By emailAddress = By.id("email");
	private By phoneNumber = By.cssSelector("input#phone");
	private By pswrd = By.name("password");
	private By confirmPswrd = By.xpath("//input[@id='password-confirm']");
	private By timeZone = By.xpath("//select[@id='timezone']/optgroup[6]/option");

	// Constructor of the page
	
	public RegistrationPageElements(WebDriver driver) {
		
		this.driver = driver;
	}
	
	// Page Actions: Fetaure(Behaviour) of the page form of methods
	
	public void enterFirstName(String firstname) {
		
		driver.findElement(firstName).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		
		driver.findElement(lastName).sendKeys(lastname);
	}

	public void enterEmailAddress(String emailaddress) {
	
	driver.findElement(emailAddress).sendKeys(emailaddress);
	}

	public void enterPhoneNumber(String phonenumber) {
	
	driver.findElement(phoneNumber).sendKeys(phonenumber);
	}
	
	public void enterPassword(String password) {
		driver.findElement(pswrd).sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmpassword) {
		driver.findElement(confirmPswrd).sendKeys(confirmpassword);
	}
	
	public void selectTimeZone() throws InterruptedException {
		WebElement timeZoneDropdown = driver.findElement(timeZone);
				timeZoneDropdown.click();
		Thread.sleep(1000);
		Select sel = new Select(timeZoneDropdown);
		sel.selectByVisibleText("Kolkota");
		/*
		 * List<WebElement> allOptions = sel.getOptions(); for(WebElement
		 * option:allOptions) { if(option.getText().equalsIgnoreCase("Kolkota")) {
		 * option.click(); break; }
		 * 
		 * }
		 */
	}
	
	public String getRegistrationPageTitle() {
		String registrationPageTitle = driver.getTitle();
		
	return registrationPageTitle;
	}
	
}