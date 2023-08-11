Feature: Login with valid credentials

  As a customer I want to login to app providing valid credentials.

  @Start @Login
  Scenario Outline: Login to app
    Given the app login page is open
    When the user enters valid <username> and <password>
    Then the user is logged in

    Examples:
      |   username     |   password   |
      | standar_user  | secret_sauce |
      | problem_user   | secret_sauce |

  @Stop @Logout
  Scenario: Logout from app
    Given the user is logged in
    When the user logs out
    Then the app login page is open

