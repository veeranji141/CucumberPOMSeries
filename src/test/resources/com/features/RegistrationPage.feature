Feature: Create a new account

Scenario: Create a new account from registration page
Given user is on registration page
And user enters first name "Veeranjaneyulu"
And user enters last name "Thota"
And user enters email Address "veeranji141@gmail.com"
And user enters phone number "8985903415"
And user enters password as "Veeru_141"
And user enters confirm password "Veeru_141"
When user selects the time zone
Then page title should be as "Register | Cathy Bell / Madison Conradis"
