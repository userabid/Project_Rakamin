Feature: Login Page Web Saucedemo

  Scenario: success login
    Given Halaman login saucedemo
    When Input username
    And Input password
    And Click login button
    Then User can login to dashboard page

  Scenario: Failed login
    Given Halaman login saucedemo
    When Input username
    And Input invalid password
    And Click login button
    Then User get error message