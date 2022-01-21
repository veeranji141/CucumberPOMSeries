package com.stepDefinitions;

import java.util.List;
import java.util.Map;

import com.driver.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LogInPageElements;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AccountsPageSteps {

	private AccountsPage accountsPage;
	private LogInPageElements logInPage = new LogInPageElements(DriverFactory.getDriver());
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		
	   List<Map<String,String>> credList = credTable.asMaps();
	    String usrName= credList.get(0).get("username");
	    String passwrd =credList.get(0).get("password");
	    DriverFactory.getDriver().get("https://yourlogo.geiger.com/login");
	    accountsPage =logInPage.doLogin(usrName, passwrd);
	}

	@Given("user is on My Account Page")
	public void user_is_on_my_account_page() {
		String title = accountsPage.getAccountsPageTitile();
		System.out.println("Accounts page title is: "+title);
	    
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		String titleOfPage = accountsPage.getAccountsPageTitile();
		System.out.println("Title of the current Page: "+ titleOfPage);
	}
	
	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expAccountsSectionsList = sectionsTable.asList();
		System.out.println("Expected Accounts Section list: "+expAccountsSectionsList);
		List<String> actualAccountSectionsList = accountsPage.getAccountsSectionslist();
		System.out.println("Actual Accounts Section list: "+actualAccountSectionsList);
		Assert.assertTrue(actualAccountSectionsList.containsAll(actualAccountSectionsList));
	   
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountSectionCount()==expectedSectionCount);
	}
}
