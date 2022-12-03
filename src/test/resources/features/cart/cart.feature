
  Feature: Cart
    #This code runs before every single scenario

    Background:
      Given User is logged in
      And User is on the home page

  #40 Check to see if a user can view their products that they added from the main page onto their carts.
    @cart
    Scenario: View products in cart
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      Then The product should be displayed.
      Then The product should have an id of.
      Then The product should have a cost of.

   #41 User is unable to leave a field blank on the shipping address page.
    Scenario: Unable to leave a field blank on shipping address page.
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      When The user clicks check out now.
      Then They should be navigated to the checkout page.
      When The user types in address fields incorrectly.
      Then An alert should popup saying please fill out this field.

    #42 A user should not be able to enter anything other than numbers for card number.
    Scenario: A user should not be able to enter anything other than numbers for card number.
      When The user clicks on the profile tab.
      When The user tries to input their payment information incorrectly.
      Then An alert should popup saying please fill out this field.

    # 43 A user should be able to delete their payment details after creation.
    Scenario: A user should be able to delete their payment details after creation.
      When The user clicks on the profile tab.
      When A user deletes their payment information.
      Then Their payment information should no longer be displayed on the page.

    #44 User is able to checkout the items in their cart after they added it from the main page.
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

    #45 User is able to add in payment information under the "Payment Details" page of the checkout page.
      Scenario: User is able to add in payment information under the "Payment Details" page of the checkout page.
        When The user clicks the cart icon for headphones.
        When The user navigates to the cart page.
        When The user clicks check out now.
        Then They should be navigated to the checkout page.
        When The user types in address fields correctly.
        When They click next on the shipping page.
        Then They should be able to edit their payment information.

    #46 User is able to press the "trash can" icon on their cart to remove an item from their cart.
    Scenario: User is able to press the "trash can" icon on their cart to remove an item from their cart.
         When The user clicks the cart icon for headphones.
         When The user navigates to the cart page.
         When The user presses the trashcan icon.
         Then Their item should be deleted from the page.
    #47 User can add different items in their cart.  (parameterize first test case)

    #48 User can change the quantity of items in their cart.
    Scenario: User can change the quantity of items in their cart.
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      When The user clicks the add quantity button.
      When The user clicks the subtract quantity button.
      Then The quantity should return to its original state.

    #49  The cart total accurately adds up to the purchase price of each item plus shipping.
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      Then The cart total should equal to twenty.