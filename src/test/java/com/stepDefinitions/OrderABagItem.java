package com.stepDefinitions;

import org.testng.Assert;

import com.driver.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LogInPageElements;
import com.pages.OrderABagItemPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderABagItem {
	private static String titleOfPage;
	
	private OrderABagItemPage orderPage = new OrderABagItemPage(DriverFactory.getDriver());
	
	private LogInPageElements logInPage = new LogInPageElements(DriverFactory.getDriver());

	@Given("user has been selected BackPacks from Shop by Product dropdown")
	public void user_has_been_selected_back_packs_from_shop_by_product_dropdown() {
		orderPage.clickOnShopByProduct();
		
	}
	@Given("user has been filtered bags by color {string}")
	public void user_has_been_filtered_bags_by_color(String string) {
		orderPage.sortingListByColor();
	}
	@Given("user has been filtered bags by price {string}")
	public void user_has_been_filtered_bags_by_price(String string) {
		orderPage.sortingListByPrice();
	}
	@Given("user has selected the bag {string} from bags list")
	public void user_has_selected_the_bag_computer_day_pack_from_bags_list(String itemName) {
	  orderPage.selectTheOrder(itemName);
	}
	@When("user clicks on the Add To Quote button")
	public void user_clicks_on_the_add_to_quote_button() {
		orderPage.clickOnAddToCartButton();
	   }
	@Then("user is navigated to Cart Page")
	public void user_is_navigated_to_cart_page() {
	
		String titleOfPage = logInPage.getLogInPageTitle();
		Assert.assertEquals(titleOfPage, "Shopping Cart | Cathy Bell / Madison Conradis");
	}

}
