package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	// By Locators
	private By userFunctionDropdown = By.xpath("//button[@id='userDropdownButton']");
	private By myAccount = By.xpath("//div[@class='dropdown-menu show']/a");
	private By accountSection = By.xpath("//ul[@class='nav nav-tabs mb-3']/li");
	
	// Constructor of the page
			
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void cilckOnUserfunctionDropdown() {
		driver.findElement(userFunctionDropdown).click();
	}
	
	public void selectMyAccount() {
		driver.findElement(myAccount).click();
	}
	
	public String getAccountsPageTitile() {
		return driver.getTitle();
	}
	
	public int getAccountSectionCount() {
		
		return driver.findElements(accountSection).size()-1;
	}
	
	public List<String> getAccountsSectionslist() {
		
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSection);
		
		for(WebElement accountHeader:accountsHeaderList) {
			String accountHeaderText = accountHeader.getText();
			System.out.println(accountHeaderText);
			accountsList.add(accountHeaderText);
		}
		return accountsList;
	}
}
