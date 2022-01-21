package com.stepDefinitions;

import com.driver.factory.DriverFactory;
import com.pages.LogInPageElements;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LogInPageSteps {

	private static String titleOfPage;
	private LogInPageElements logInPage = new LogInPageElements(DriverFactory.getDriver());
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
	   DriverFactory.getDriver().get("https://yourlogo.geiger.com/login");	 
		
	}

	@When("user gets the title of the login page")
	public void user_gets_the_title_of_the_login_page() {
		titleOfPage = logInPage.getLogInPageTitle();
		System.out.println("Title of the current Page: "+ titleOfPage);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
	   
		//Assert.assertTrue(titleOfPage.contains(expectedTitleName));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	  
		Assert.assertTrue(logInPage.isForgotLinkExists());
	}

	@Given("user enters user name {string}")
	public void user_enters_user_name(String username) {
	  logInPage.enterUsername(username);
	}

	@Given("user enters password {string}")
	public void user_enters_password(String password) {
	    logInPage.enterPassword(password);
	}

	@Given("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   logInPage.clickOnLogInButton();
	}

	@Then("user gets the title of the Home page")
	public void user_gets_the_title_of_the_Home_page() {
		titleOfPage = logInPage.getLogInPageTitle();
		System.out.println("Title of the current Page: "+ titleOfPage);
	}

}
