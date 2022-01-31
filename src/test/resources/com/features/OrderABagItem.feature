Feature: Book am Item from BackPacks
Background:
Given user has already logged into application
|username|password|
|veeranji141@gmail.com|Veeru@141|

Scenario: Add an Order a bag from backpack to the Cart
Given user is on My Account Page
And user has been selected BackPacks from Shop by Product dropdown
And user has been filtered bags by color "Black"
And user has been filtered bags by price "$10.01 - $25.00"
And user has selected the bag "The Armada Sling Backpack" from bags list
When user clicks on the Add To Quote button
Then user is navigated to Cart Page