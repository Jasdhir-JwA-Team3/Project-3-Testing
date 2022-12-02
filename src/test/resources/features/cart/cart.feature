
  Feature: Cart
    #This code runs before every single scenario

    Background:
      Given User is logged in
      And User is on the home page

  #Check to see if a user can view their products that they added from the main page onto their carts.
    @cart
    Scenario: View products in cart
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      Then The product should be displayed.
      Then The product should have an id of one.
      Then The product should have a cost of twenty.


  #User is unable to leave a field blank on the shipping address page.
  Scenario Outline: Unable to leave field blank
      When The user clicks the cart icon for headphones.
      When The user navigates to the cart page.
      When The user clicks checkout.
      When The user types in "<fname>" in the firstname field.
      When The user types in "<address>" in the address line one field.
      When The user types in "<city>" in the city field.
      When The user types in "<Zip>" in the postal code field.
      When The user types in "<country>" in the country field.
      Then The user should be unable to navigate to the checkout page.
      Examples:
        | fname | address | city | Zip | country |
        | Anwar | 5000 summer street.| New York | 90045| United States|


  #A user should not be able to enter anything other than numbers for card number.



  #A user should be able to delete their payment details after creation.