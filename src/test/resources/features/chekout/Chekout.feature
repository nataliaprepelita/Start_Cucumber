@Regression
Feature: Add product to cart

  As a customer
  I want to be able to add products to cart and control their amount
  So that I know how much I have bought

  @Login @Start
  Scenario Outline: Login to app
    Given the app login page is open
    When the user enters valid <username> and <password>
    Then the user is logged in

    Examples:
      |   username     |   password   |
      | standard_user  | secret_sauce |
      | problem_user   | secret_sauce |

  @AddProduct @Stop
  Scenario Outline: Add product to cart
    Given the app is on product page
    When the user adds <product> to cart
    Then the cart counter is updated by 1

    Examples:
      |   product           |
      |   Sauce Labs Onesie |


