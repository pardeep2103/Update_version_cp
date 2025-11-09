Feature: User Login
@set2
Scenario Outline: Valid Login with different browsers and credentials
  Given the user opens the "<browser>" browser
  And the user is on the Login page
  And the user enters a login username "<username>"
  And the user enters a login password "<password>"
  And the user clicks the Login button
  Then the user should see the welcome message "Welcome <username>"

Examples:
  | browser | username    | password    |
  | chrome  | dEEP@2809   | dEEP@2809   |
  | edge    | dEEP@2809   | dEEP@2809   |
@set3
Scenario Outline: Invalid Login with different browsers and credentials
  Given the user opens the "<browser>" browser
  And the user is on the Login page
  And the user enters a login username "<username>"
  And the user enters a login password "<password>"
  And the user clicks the Login button
  Then the user should see alert message "User does not exist."

Examples:
  | browser | username   | password    |
  | chrome  | deep2898   | Deep@2209   |
  | edge    | deep2898   | Deep@2209   |