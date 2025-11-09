Feature: Place Order Functionality

@final
Scenario Outline: Verify Place Order Modal and Purchase Flow
   Given the user opens the "<browser>" browser
  And the user is on the Login page
  And the user enters a login username "<username>"
  And the user enters a login password "<password>"
  And the user clicks the Login button
    Then the user should see the welcome message "Welcome <username>"

  Then the user clicks first product
 # Then the user reads product details
  And the user adds product to cart
  And the user accepts the alert
  And the user clicks Home button
  
    Then the user clicks second product
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
 # And user is on Cart page
    Then user verifies the cart page is loaded
    Then user reads product 1 details
    Then user reads product 2 details
    Then user reads product 3 details
    Then user deletes the 3rd product
    Then user reads updated product 3 details

    Then user reads total price
    Then user clicks place order
  Then user verifies place order popup is displayed

  When the user enters Name "<name>"
  And the user enters Country "<country>"
  And the user enters City "<city>"
  And the user enters Credit Card "<card>"
  And the user enters Month "<month>"
  And the user enters Year "<year>"
  And the user clicks Purchase
  Then the confirmation popup should be displayed
  And the user reads confirmation details
  And the user clicks OK

Examples:
  | browser | username   | password   | name     | country | city   | card       | month | year |
  | chrome  | dEEP@2809 | dEEP@2809 | Deep | India     | Delhi     | 1234567890 | Jan   | 2025 |
  | edge    | dEEP@2809 | dEEP@2809 | Deep | India      | Delhi | 9876543210 | Feb   | 2026 |

@wofd
Scenario Outline: Click Purchase Without Entering Details
  Given the user opens the "<browser>" browser
 And the user is on the Login page
  And the user enters a login username "<username>"
  And the user enters a login password "<password>"
  And the user clicks the Login button
  Then the user should see the welcome message "Welcome <username>"
  When the user clicks first product
  And the user adds product to cart
  And the user accepts the alert
  And the user clicks Home button
  And the user clicks cart button
  Then user clicks place order
  And the user clicks Purchase without entering details
  Then an alert should be displayed with text "Please fill out Name and Creditcard."
  And the user accepts the alert

Examples:
  | browser | username   | password |
  | chrome  | dEEP@2809 | dEEP@2809 |
  | edge    | dEEP@2809 | dEEP@2809 |
