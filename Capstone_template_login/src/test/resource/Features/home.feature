Feature: Home Page Product Selection

@set4

Scenario Outline: User selects products from Home Page
  Given the user opens the "<browser>" browser
  And the user is on the Login page
  And the user enters a login username "<username>"
  And the user enters a login password "<password>"
  And the user clicks the Login button
    Then the user should see the welcome message "Welcome <username>"

  When the user clicks first product
  When the user clicks second product 
  When the user clicks third product   
  When the user clicks foruth product 
Examples:
  | browser | username    | password    |
  | chrome  | dEEP@2809   | dEEP@2809   |
  | edge    | dEEP@2809   | dEEP@2809   |
