Feature: Users can sort items in inventory

Scenario: user can sort items from cheapest to most expensive
Given User already login the SwagLabs site
When User click icon sort
And User sort by price (low to high)
Then Users can see the products have been sorted