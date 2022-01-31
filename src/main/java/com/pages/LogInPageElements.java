package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPageElements {
	private boolean transfer = true;

	private WebDriver driver;
	
	// By Locators
	private By emailId = By.id("email");
	private By password = By.xpath("//input[@id='password']");
	private By logInButton = By.xpath("//button[contains(text(),'Log In')]");
	private By forgotLink = By.linkText("Forgot Your Password?");
	
	// Constructor of the Page
	
	  public LogInPageElements(WebDriver driver) { this.driver= driver; }
	 
		
	// Page Actions: Fetaure(Behaviour) of the page form of methods
	public String getLogInPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean isForgotLinkExists() {
		return driver.findElement(forgotLink).isDisplayed();
	}
	
	
	  public void enterUsername(String userName) {
	  driver.findElement(emailId).sendKeys(userName); }
	  
	  public void enterPassword(String Password) {
	  driver.findElement(password).sendKeys(Password); }
	  
	  public void clickOnLogInButton() { driver.findElement(logInButton).click(); }
	 
	
	
	  public synchronized AccountsPage doLogin(String un, String pwd) {
	  
	  try { 
	  driver.findElement(emailId).sendKeys(un);
	  driver.findElement(password).sendKeys(pwd);
	  wait(500);
	  driver.findElement(logInButton).click(); 
	  } 
	  catch (InterruptedException e) {
	  
	  e.printStackTrace(); }
	  
	  transfer=false; notifyAll(); return new AccountsPage(driver); }
	 
}
