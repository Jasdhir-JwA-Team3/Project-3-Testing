@User
  Feature: User

    Scenario: User logs in
      Given user opens Home page
      When user clicks sign in
      When user enters email "project03test@gmail.com"
      When user enters password "Password1*"
      Then user successfully logs in

    Scenario Outline: User not able to log in
      Given user opens Home page
      When user clicks sign in
      When user enters email "<Email>"
      When user enters password "<Password>"
      Then user is unable to log in

      Examples:
        | Email                   | Password   |
        | project04test@gmail.com | Password1* |
        | project03test@gmail.com | Password*2 |
        | project04test@gmail.com | Password*2 |
        | none                    | none       |

    Scenario: User navigation
      When user opens Home page
      When user clicks sign in
      When user clicks Don't have an account
      When user clicks they already have an account
      Then user should be back on the login page

    Scenario: User registers successfully
      When user opens Home page
      When user clicks Register link
      When user enters valid registration info "jeffy", "Jefferson", "MrJeff1*"
      Then user should be registered and on log in page

    Scenario Outline: User fails to register
      When user opens Home page
      When user clicks Register link
      When user enters invalid registration info "<first_name>", "<last_name>", "<email>", "<password>"
      Then user should be not be registered or on log in page

      Examples:
        | first_name  | last_name     | email          | password |
        | jeffy1*     | jefferson     | valid email    | Mrjeff1* |
        | none        | jefferson     | valid email    | Mrjeff1* |
        | jeffy       | jefferson1*   | valid email    | Mrjeff1* |
        | jeffy       | none          | valid email    | Mrjeff1* |
        | jeffy       | jefferson     | invalid email  | Mrjeff1* |
        | jeffy       | jefferson     | none           | Mrjeff1* |
        | jeffy       | jefferson     | valid email    | Mr1*     |
        | jeffy       | jefferson     | valid email    | mrjeff1* |
        | jeffy       | jefferson     | valid email    | Mrjeff** |
        | jeffy       | jefferson     | valid email    | Mrjeff11 |
        | jeffy       | jefferson     | valid email    | none     |
        | none        | none          | none           | none     |

    @UpdateProfile
    Scenario: User successfully updates profile
      When user logs in
      When user clicks profile
      When User enters update information "jeffy", "Jefferson", "MrJeff1*"
      Then user clicks update and has successfully updates their information

    @FailUpdateProfile
    Scenario Outline: User fails to update profile
      When user logs in
      When user clicks profile
      When User enters update information "<first_name>", "<last_name>", "<password>"
      Then user clicks update and has fails to update their information

      Examples:
        | first_name | last_name  | password |
        | MrJeff1*    | MrJeff1*  | p        |
        | none        | none      | none     |

    Scenario: User deactivates
      When user logs in
      When user clicks profile
      When user types deactivate and deactivates account
      Then user should be logged out and not able to log back in

    @SuccessfullyUpdatePayment
    Scenario: User successfully creates payment
      When user logs in to edit card info
      When user clicks profile
      When User enters payment information "1234567891011121", "01/01/2050", "123"
      Then user clicks add payment and creates a new payment method

    @FailUpdatePayment
    Scenario Outline: User fails to create payment
      When user logs in to edit card info
      When user clicks profile
      When User enters payment information "<card_number>", "<date>", "<ccv>"
      Then user clicks add payment and is unable to create a new payment method

      Examples:
        | card_number      | date       | ccv |
        | p8*              | 01/01/2050 | 123 |
        | 1234567891011121 | 01/01/2050 | p8* |
        | 1234567891011121 | 01/01/1950 | 123 |

    @DarkLight
    Scenario: User toggles light and dark mode
      When user opens Home page
      Then user is on light mode
      When user clicks to switch to dark mode
      Then user is on dark mode

    @ClashingAppearance
    Scenario: Appearance settings not saved
      When user1 logs in
      When user1 changes appearance to dark mode
      When user logs out
      When user2 logs in
      Then user2 should have light mode appearance