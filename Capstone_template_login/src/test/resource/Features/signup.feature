Feature: Signup functionality
@set1
  Scenario Outline: User signs up with valid credentials
      Given the user opens the "<browser>" browser
    When the user is on the homepage
    And the user clicks on the signup link
    And the user enters "<username>" and "<password>"
    And the user clicks on the signup button
    Then a signup confirmation alert should appear

    Examples:
   |browser   | username   | password   |
   |chrome    | testuser1  | pass123    |
   |edge      | demoUser2  | demoPass   |
