package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderABagItemPage {
	
	private WebDriver driver;
	
	//By Locators
	private By shopByProduct = By.xpath("//a[contains(text(),'Shop by Product')]");
	private By bagsAndTotes = By.xpath("//ul[@class='dropdown-menu show']/li[2]");
	private By backPackOption = By.xpath("//ul[@class='dropdown-menu flyout-menu show']/li[1]");
	private By sortByColor = By.xpath("//label[contains(text(),'Black')]");
	private By sortByPrice = By.xpath("//label[contains(text(),'$10.01 - $25.00')]");
	private By itemsList = By.xpath("//div[@class='card-deck card-deck-wrap card-deck-wrap-2 card-deck-wrap-lg-3 card-deck-wrap-xl-4 card-deck-wrap-2x-5 justify-content-start']");
	//private By itemsList = By.tagName("a");
	private By addToCartBtn = By.xpath("//button[contains(text(),'ADD TO QUOTE')]");
	
	// Constructor of the page
	
	
	  public OrderABagItemPage(WebDriver driver)
	  { 
		  this.driver = driver; 
	  }
	 
	
	// Page Actions: Fetaure(Behaviour) of the page form of methods
	
	public void clickOnShopByProduct() {
		System.out.println("User is ready to select the shop by product");
		driver.findElement(shopByProduct).click();
		driver.findElement(bagsAndTotes).click();
		driver.findElement(backPackOption).click();
		
	}
	public void sortingListByColor() {
		
		
		driver.findElement(sortByColor).click();
	}
	
	public void sortingListByPrice() {
		
		driver.findElement(sortByPrice).click();
	}
	
	public void selectTheOrder(String itemName) {
		/*
		 * int size = driver.findElements(By.tagName("iframe")).size();
		 * System.out.println("Number of elements are present:"+size);
		 */
		
		  List<WebElement> items = driver.findElements(itemsList); 
		  System.out.println(itemName);
		 for(WebElement item:items) {
				
			String itemName1 = item.getText();
			String[] backPackName = itemName1.split("Item");
			System.out.println(backPackName);
				  System.out.println(backPackName[0]);
				 
			 if(backPackName[0].equalsIgnoreCase(itemName)) {
				 System.out.println("Ready to click on item");
				 item.click();
				 break;
			 }
		 }
		 
		
	}
	public void clickOnAddToCartButton() {
		driver.findElement(addToCartBtn).click();
	}
	

}
