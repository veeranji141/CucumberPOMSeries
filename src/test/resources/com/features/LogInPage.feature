Feature: Login Page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the login page
Then page title should be "Login | Cathy Bell / Madison Conradis"

Scenario: Forgot password link
Given user is on login page
Then forgot password link should be displayed

Scenario Outline: Login with correct credentials
Given user is on login page
And user enters user name "<user name>"
And user enters password "<password>"
And user clicks on Login button
Then user gets the title of the Home page
And page title should be "Cathy Bell / Madison Conradis"

Examples: 
 			|user name| password|
 			|veera@gmail.com| 89859034|
 			|Anji123@gmail.com| Veeru_141|
 			|veeranji141@gmail.com| Veeru@141|
 			

