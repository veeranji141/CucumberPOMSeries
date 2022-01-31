Feature: Account Page Feature

Background: 
Given user has already logged into application
|username|password|
|veeranji141@gmail.com|Veeru@141|

Scenario: Accounts page title
Given user is on My Account Page
When user gets the title of the page
Then page title should be "Order History | Cathy Bell / Madison Conradis"

Scenario: Account section count
Given user is on My Account Page
Then user gets accounts section
| Order History|
| Quote History|
| Address Book|
| Profile|
And accounts section count should be 4
