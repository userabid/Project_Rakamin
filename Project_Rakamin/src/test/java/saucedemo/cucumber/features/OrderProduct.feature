Feature: Product Menu

  Scenario: Verify user is able to buy products
    Given User already login the SwagLabs site
    When User click Add to Cart button on one of the product or more
    And User click Cart icon on the top right side
    And User check the shopping list details & click the Checkout button
    And User fill the buyer's biodata form & click the Continue button
    And User double-check the shopping list & click the Finish button
    Then User successfully purchased the product & directed to Checkout: Complete! page
    And User can back to Homepage with click the Back Home button