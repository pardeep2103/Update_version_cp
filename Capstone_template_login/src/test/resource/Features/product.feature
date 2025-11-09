Feature: Product Details and Add to Cart

@set5
Scenario Outline: Verify single product PDP and add to cart flow
  Given the user opens the "<browser>" browser
  And the user is on the Login page
  And the user enters a login username "<username>"
  And the user enters a login password "<password>"
  And the user clicks the Login button
    Then the user should see the welcome message "Welcome <username>"

  When the user clicks first product
 # Then the user reads product details
  And the user adds product to cart
  And the user accepts the alert
  And the user clicks Home button
  
    When the user clicks second product
 # Then the user reads product details
  And the user adds product to cart
  And the user accepts the alert
  And the user clicks Home button
  
    When the user clicks third product
 # Then the user reads product details
  And the user adds product to cart
  And the user accepts the alert
  And the user clicks Home button
 # And the user clicks Cart button
 
 When the user clicks foruth product
 # Then the user reads product details
  And the user adds product to cart
  And the user accepts the alert
  And the user clicks cart button
 # And the user clicks Cart button

Examples:
  | browser | username  | password  |
  | chrome  | dEEP@2809 | dEEP@2809 |
  | edge    | dEEP@2809 | dEEP@2809 |
