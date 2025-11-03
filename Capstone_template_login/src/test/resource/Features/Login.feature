Feature: User Login

@set1
Scenario: Valid Login
  Given the user is on the Login page
  And the user enters a login username "dEEP@2809"
  And the user enters a login password "dEEP@2809"
  And the user clicks the Login button
  Then the user should see the welcome message "Welcome dEEP@2809"

@set2
Scenario: Invalid Login - Wrong Username and Password
  Given the user is on the Login page
  And the user enters a login username "deep2898"
  And the user enters a login password "Deep@2209"
  And the user clicks the Login button
  Then the user should see alert message "User does not exist."
