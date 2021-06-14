Feature: Smoke
  As a user
  I want to test some main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check the switching language option
    Given User opens '<homePage>' page
    And User checks current website language is '<language>'
    When User clicks on language button and switch the language
    Then User checks location according to 'ru' language

    Examples:
      | homePage             | language      |
      | https://www.ebay.com | United States |


  Scenario Outline: Check that product code corresponds only for one product
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that amount of products in search results are '<amountOfProducts>'

    Examples:
      | homePage             | keyword      | amountOfProducts |
      | https://www.ebay.com | 184793892456 | 1                |


  Scenario Outline: Check sing in with bad options
    Given User opens '<homePage>' page
    And User checks sign in button visibility
    And User clicks 'Sign In' button
    And User checks email field visibility on sign page
    And User checks another sign in options visibility
    When User checks sing in with '<login>' option
    Then User checks that warning is appear

    Examples:
      | homePage             | login |
      | https://www.ebay.com | Test  |

  Scenario Outline: Check register in with bad options
    Given User opens '<homePage>' page
    And User checks register button visibility
    And User clicks to register button
    When User checks register option with '<info>' option
    And User check register option with '<email>' and '<password>'
    Then User checks check the warning message


    Examples:
      | homePage             | info | email         | password        |
      | https://www.ebay.com | Test | test@test.cam | test1111113Test |


  Scenario Outline: Check Advanced Search
    Given User opens '<homePage>' page
    And User clicks advanced search button
    When User enters '<keyword>' with '<lowerPrice>' and '<higherPrice>' price
    Then User check that list of product match

    Examples:
      | homePage             | keyword       | lowerPrice | higherPrice |
      | https://www.ebay.com | apple watch 6 | 150        | 200         |


  Scenario Outline: Check add product to cart more than available
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on product in question
    When User change the quantity with bigger '<value>'
    Then User gets the change quantity message

    Examples:
      | homePage             | keyword      | value |
      | https://www.ebay.com | 184793892456 | 5     |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on product in question
    When User clicks add product to cart
    Then User checks that mentioned '<product>' placed in cart

    Examples:
      | homePage             | keyword      | product              |
      | https://www.ebay.com | 184793892456 | Apple Watch Series 5 |

  Scenario Outline: Check remove product from cart

    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on product in question
    And User clicks add product to cart
    When User remove product from cart
    Then User checks that cart is empty

    Examples:
      | homePage             | keyword      |
      | https://www.ebay.com | 184793892456 |