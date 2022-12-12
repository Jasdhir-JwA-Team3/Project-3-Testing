@userorder
Feature: User can view orders

Background:
  Given User is logged in
  And User is on the home page

  Scenario: User navigates to Orders page
    Given User is on the home page
    When User clicks orders button
    Then The user is taken to the orders page

  Scenario: User checks previous orders
    Given User is on the home page
    When User clicks orders button
    Then User sees information about previous orders they've made
  @CreateOrder
  Scenario: User creates order and checks information on Orders page
    When The user clicks the cart icon for headphones.
    When The user navigates to the cart page.
    When The user clicks check out now.
    Then They should be navigated to the checkout page.
    When The user types in address fields correctly.
    When They click next on the shipping page.
    When They select a payment method.
    When They click submit payment.
    When They click place order.
    When User navigates to Orders page
    Then User sees the headphones order