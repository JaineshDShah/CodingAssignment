Feature: feature to test successful flight booking

  @AssignmentScenario
  # This scenario is automated
  # Scenario-1
  Scenario Outline: To test the happy flow for flight booking
    Given user has launched the travel booking page
    And user selects the source as "<source>"
    And user selects the destination as "<destination>"
    And clicks on Search button
    Then user is displayed with the search results
    And user selects a flight with flight number "<flightNumber>"
    Then user is navigated to the flight reservation form
    And user fills the form with details "<firstName>" "<lastName>" "<address>" "<city>" "<state>" "<zipCode>" "<cardType>" "<creditCardNumber>" "<month>" "<year>" "<nameOnCard>" "<rememberMe>"
    And clicks on Purchase Flight
    Then user is navigated to the confirmation page

    Examples: 
      | source | destination | flightNumber | firstName | lastName | address | city | state | zipCode | cardType | creditCardNumber | month | year | nameOnCard | rememberMe |
      | Boston | London      |     4346 | Peter    | Anderson     | Theklavej | Copenhagen | Denmark | 101202 | American Express | 1100110011001100 | 5 | 2023 | Julian Holmen | true |
      
  # This scenario is not automated
  # Scenario-2
  Scenario Outline: To test the validations on Reservation form
  # zipCode should not have alphabetic characters
  # Card Year should be a future year
  # flight number cannot be alphabetic
  # Card number is of 16 digits
  # Card month should be between 1 and 12
    Given user has launched the travel booking page
    And user selects the source as "<source>"
    And user selects the destination as "<destination>"
    And clicks on Search button
    Then user is displayed with the search results
    And user selects a flight with flight number "<flightNumber>"
    Then user is navigated to the flight reservation form
    And user fills the form with details "<firstName>" "<lastName>" "<address>" "<city>" "<state>" "<zipCode>" "<cardType>" "<creditCardNumber>" "<month>" "<year>" "<nameOnCard>" "<rememberMe>"
    Then user is prompted with validation errors
    And clicks on Purchase Flight
    Then user is navigated to the confirmation page

    Examples: 
      | source | destination | flightNumber | firstName | lastName | address | city | state | zipCode | cardType | creditCardNumber | month | year | nameOnCard | rememberMe |
      | Boston | London      |     4346 | Peter    | Anderson     | Theklavej | Copenhagen | Denmark | 101202 | American Express | 1100110011001100 | 5 | 2023 | Julian Holmen | true |


# This scenario is not automated
# Scenario-3      
Scenario Outline: To test the mandatory field validations on Reservation form
  
    And user selects the source as "<source>"
    And user selects the destination as "<destination>"
    And clicks on Search button
    Then user is displayed with the search results
    And user selects a flight with flight number "<flightNumber>"
    Then user is navigated to the flight reservation form
    And user clicks on the Purchase flight button #or Purchase Flight - button should be disabled (depending on design decision)
    Then user is prompted with alerts for all the mandatory fields required
    And user fills the form with details "<firstName>" "<lastName>" "<address>" "<city>" "<state>" "<zipCode>" "<cardType>" "<creditCardNumber>" "<month>" "<year>" "<nameOnCard>" "<rememberMe>"    
    And clicks on Purchase Flight
    Then user is navigated to the confirmation page

    Examples: 
      | source | destination | flightNumber | firstName | lastName | address | city | state | zipCode | cardType | creditCardNumber | month | year | nameOnCard | rememberMe |
      | Boston | London      |     4346 | Peter    | Anderson     | Theklavej | Copenhagen | Denmark | 101202 | American Express | 1100110011001100 | 5 | 2023 | Julian Holmen | true |
      
      
# This scenario is not automated
# Scenario-4
Scenario Outline: To check if the search results are as per the details provided on Search Page
  
    And user selects the source as "<source>"
    And user selects the destination as "<destination>"
    And clicks on Search button
    Then user is displayed with the search results
    And user retrieves the details of Search Results
    And user compares it with the search criteria    
    Then user confirms that search results are as per criteria provided

    Examples: 
      | source | destination | flightNumber | firstName | lastName | address | city | state | zipCode | cardType | creditCardNumber | month | year | nameOnCard | rememberMe |
      | Boston | London      |     4346 | Peter    | Anderson     | Theklavej | Copenhagen | Denmark | 101202 | American Express | 1100110011001100 | 5 | 2023 | Julian Holmen | true |


# This scenario is not automated
# Scenario-5
Scenario Outline: To check if the booking details provided on reservation form are same on Confirmation page
  
    And user selects the source as "<source>"
    And user selects the destination as "<destination>"
    And clicks on Search button
    Then user is displayed with the search results
    And user selects a flight with flight number "<flightNumber>"
    Then user is navigated to the flight reservation form
    And user clicks on the Purchase flight button #or Purchase Flight - button should be disabled (depending on design decision)
    Then user is prompted with alerts for all the mandatory fields required
    And user fills the form with details "<firstName>" "<lastName>" "<address>" "<city>" "<state>" "<zipCode>" "<cardType>" "<creditCardNumber>" "<month>" "<year>" "<nameOnCard>" "<rememberMe>"    
    And clicks on Purchase Flight
    Then user is navigated to the confirmation page
    And user captures all the information on the confirmation page
    And user compares it with the information provided on the Reservation form

    Examples: 
      | source | destination | flightNumber | firstName | lastName | address | city | state | zipCode | cardType | creditCardNumber | month | year | nameOnCard | rememberMe |
      | Boston | London      |     4346 | Peter    | Anderson     | Theklavej | Copenhagen | Denmark | 101202 | American Express | 1100110011001100 | 5 | 2023 | Julian Holmen | true |