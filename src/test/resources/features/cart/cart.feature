@cart
Feature: Cart
    #This code runs before every single scenario

    Background:
      Given User is logged in
      And User is on the home page

  #40 Check to see if a user can view their products that they added from the main page onto their carts.(PASS)
    Scenario: View products in cart
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      Then The product should be displayed.
      Then The product should have an id of.
      Then The product should have a cost of.

@UserAddressNoBlank
   #User is unable to leave a field blank on the shipping address page full check on all fields(PASS)
    Scenario Outline: Unable to leave a field blank on shipping address page.
      Given The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      And The user clicks check out now.
      And They should be navigated to the checkout page.
      And The user types in a "<First>" in first name field.
      And The user types in a "<Last>" in last name field.
      And The user types in a "<Address1>" in address1 field.
      And The user types in a "<Address2>" in address2 field.
      And The user types in a "<City>" in city field.
      And The user types in a "<State>" in state field.
      And The user types in a "<Zip>" in zip field.
      And The user types in a "<Country>" in country field.
      And They click next on the shipping page.
      Then They should be notified of a needed "<Field>".
    Examples:
      | First | Last  | Address1 | Address2   | City     | State | Zip   | Country | Field     |
      |       | Donny | 12 Zebra | 1332 Fuzzy | Portland | OR    | 97035 | USA     | firstName |
      | Benny |       | 12 Zebra | 1332 Fuzzy | Portland | OR    | 97035 | USA     | lastName  |
      | Benny | Donny |          |            | Portland | OR    | 97035 | USA     | address   |
      | Benny | Donny | 12 Zebra | 1332 Fuzzy |          | OR    | 97035 | USA     | city      |
      | Benny | Donny | 12 Zebra | 1332 Fuzzy | Portland |       | 97035 | USA     | state     |
      | Benny | Donny | 12 Zebra | 1332 Fuzzy | Portland | OR    |       | USA     | zip       |
      | Benny | Donny | 12 Zebra | 1332 Fuzzy | Portland | OR    | 97035 |         | country   |

    #42 A user should not be able to enter anything other than numbers for card number.(FAIL)
    Scenario: A user should not be able to enter anything other than numbers for card number.
      When The user clicks on the profile tab.
      When The user tries to input their payment information incorrectly.
      When The user clicks add payment.
      Then An alert should popup saying please incorrect payment.


    # 43 A user should be able to delete their payment details after creation.(FAIL)
    Scenario: A user should be able to delete their payment details after creation.
      When The user clicks on the profile tab.
      When A user deletes their payment information.
      Then Their payment information should no longer be displayed on the page.



    #44 User is able to checkout the items in their cart after they added it from the main page.(PASS)
    Scenario: User is able to checkout the items in their cart after they added it from the main page.
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      When The user clicks check out now.
      Then They should be navigated to the checkout page.
      When The user types in address fields correctly.
      When They click next on the shipping page.
      When They select a payment method.
      When They click submit payment.
      When They click place order.
      Then An order confirmation should be displayed.


    #45 User is able to add in payment information under the "Payment Details" page of the checkout page.(FAIL)
      Scenario: User is able to add in payment information under the "Payment Details" page of the checkout page.
        When The user clicks the cart icon for headphones.
        When The user navigates to the cart page.
        When The user clicks check out now.
        Then They should be navigated to the checkout page.
        When The user types in address fields correctly.
        When They click next on the shipping page.
        Then They should be able to edit their payment information.


    #46 User is able to press the "trash can" icon on their cart to remove an item from their cart.(PASS)
    Scenario: User is able to press the "trash can" icon on their cart to remove an item from their cart.
         When The user clicks the cart icon for headphones.
         When The user navigates to the cart page.
         When The user presses the trashcan icon.
         Then Their item should be deleted from the page.

    #47 User can add different items in their cart.  (parameterize first test case)

    #48 User can change the quantity of items in their cart.(PASS)
    Scenario: User can change the quantity of items in their cart.
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      When The user clicks the add quantity button.
      When The user clicks the subtract quantity button.
      Then The quantity should return to its original state.


    #49  The cart total accurately adds up to the purchase price of each item plus shipping (PASS).
      Scenario: The cart total accurately adds up to the purchase price of each item plus shipping.
        When The user clicks the cart icon for headphones.
        When The user navigates to the cart page.
        Then The cart total should be accurate.