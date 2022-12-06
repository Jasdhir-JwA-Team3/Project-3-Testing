@userorder
Feature: User can view orders

Background:
  Given User is logged in
  And User is on the home page

  Scenario:
    Given User is on the home page
    When User clicks orders button
    Then The user is taken to the orders page