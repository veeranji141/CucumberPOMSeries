package com.stepDefinitions;

import org.junit.Assert;

import com.driver.factory.DriverFactory;
import com.pages.RegistrationPageElements;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageSteps {
	
	private static String titleOfRegistrationPage;
	private RegistrationPageElements registrationPage = 
			new RegistrationPageElements(DriverFactory.getDriver());
	

	@Given("user is on registration page")
	public void user_is_on_registration_page() {
	    DriverFactory.getDriver().get("https://yourlogo.geiger.com/register");
	}

	@Given("user enters first name {string}")
	public void user_enters_first_name(String firstname) {
		registrationPage.enterFirstName(firstname);
	  
	}

	@Given("user enters last name {string}")
	public void user_enters_last_name(String lastname) {
	    registrationPage.enterLastName(lastname);
	}

	@Given("user enters email Address {string}")
	public void user_enters_email_address(String emailaddress) {
	    registrationPage.enterEmailAddress(emailaddress);
	}

	@Given("user enters phone number {string}")
	public void user_enters_phone_number(String phonenumber) {
		registrationPage.enterPhoneNumber(phonenumber);

	}

	@Given("user enters password as {string}")
	public void user_enters_password_as(String password) {
		registrationPage.enterPassword(password);
	  
	}

	@Given("user enters confirm password {string}")
	public void user_enters_confirm_password(String confirmpassword) {
		registrationPage.enterConfirmPassword(confirmpassword);
	}

	@When("user selects the time zone")
	public void user_selects_the_time_zone() throws InterruptedException {
		registrationPage.selectTimeZone();
	}

	@Then("page title should be as {string}")
	public void page_title_should_be_as(String expectedTitleOfRegistrationPage) {
		titleOfRegistrationPage = registrationPage.getRegistrationPageTitle();
		System.out.println("Title of the Registration Page:"+titleOfRegistrationPage);
		Assert.assertTrue(titleOfRegistrationPage.equalsIgnoreCase(expectedTitleOfRegistrationPage));
	}
}
