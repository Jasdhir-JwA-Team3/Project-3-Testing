package com.revature.steps;

import com.revature.pages.CartPage;
import com.revature.runner.MainRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ja.前提;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class CartSteps {
    WebDriverWait wait = new WebDriverWait(MainRunner.driver, Duration.ofSeconds(2));
//Test40
    @When("The user clicks the cart icon for headphones.")
    public void the_user_clicks_the_cart_icon_for_headphones(){
        Boolean flag = true;
        try {
            MainRunner.homePage.view_headphone();
            wait.until(ExpectedConditions.visibilityOf(MainRunner.cartPage.headphonesbuyicon));
            MainRunner.cartPage.headphonesbuyicon.click();
        }catch(Exception e){
            flag = false;
             Assert.assertTrue(flag);
        }
     }
    @When("The user navigates to the cart page.")
    public void the_user_navigates_to_the_cart_page() {
       MainRunner.cartPage.cartnavbartabicon.click();
       wait.until(ExpectedConditions.urlToBe(MainRunner.cartPage.carturlpage));
       }
    @Then("The product should be displayed.")
    public void the_product_should_be_displayed() {
        Assert.assertTrue(MainRunner.cartPage.headphonenamedisplay.isDisplayed());
     }

    @Then("The product should have an id of.")
    public void the_product_should_have_an_id_of() {
        Assert.assertTrue(MainRunner.cartPage.headphoneidisplay.isDisplayed());

    }
    @Then("The product should have a cost of.")
    public void the_product_should_have_a_cost_of() {
        Assert.assertTrue(MainRunner.cartPage.totalCostofOrderDisplay.isDisplayed());
      }


    @When("The user clicks check out now.")
    public void the_user_clicks_check_out_now() {


        MainRunner.cartPage.checkoutnowbtn.click();
     }
    @Then("They should be navigated to the checkout page.")
    public void they_should_be_navigated_to_the_checkout_page() {
        Assert.assertEquals(MainRunner.driver.getCurrentUrl(),MainRunner.cartPage.checkouturlpage);

    }
    @When("The user types in address fields incorrectly.")
    public void the_user_types_in_address_fields_incorrectly() throws InterruptedException {
        wait.until(ExpectedConditions.urlToBe(MainRunner.cartPage.checkouturlpage));
        MainRunner.cartPage.firstnameinputfield.sendKeys(MainRunner.cartPage.fname);
        MainRunner.cartPage.lastnameinputfield.sendKeys(MainRunner.cartPage.lname);
        MainRunner.cartPage.cityInputfield.sendKeys(MainRunner.cartPage.city);
        MainRunner.cartPage.countryInputfield.sendKeys(MainRunner.cartPage.country);
     }
    @When("They click next on the shipping page.")
    public void theyClickNextOnTheShippingPage() {
        MainRunner.cartPage.nextbuttonshippingpage.click();
        wait.until(ExpectedConditions.urlToBe(MainRunner.cartPage.checkouturlpage));

    }

     //Test 42
     @When("The user clicks on the profile tab.")
     public void the_user_clicks_on_the_profile_tab() {
        MainRunner.cartPage.profilenavbartab.click();
        wait.until(ExpectedConditions.urlToBe(MainRunner.cartPage.profileurlpage));


    }
    @When("The user tries to input their payment information incorrectly.")
    public void the_user_tries_to_input_their_payment_information_incorrectly() {
        MainRunner.cartPage.cardnumberinputfield.sendKeys(MainRunner.cartPage.creditcardnumber);
        MainRunner.cartPage.cardnumberinputfield.sendKeys(MainRunner.cartPage.cvvnumber);
        MainRunner.cartPage.cardnumberinputfield.sendKeys(MainRunner.cartPage.expdatenumber);
     }

    @When("The user clicks add payment.")
    public void theUserClicksAddPayment() {
      MainRunner.cartPage.addpaymentsubmitbutton.click();
    }


    @Then("An alert should popup saying please incorrect payment.")
    public void anAlertShouldPopupSayingPleaseIncorrectPayment() {
        Boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(MainRunner.cartPage.alert));
            Assert.assertTrue(flag);
        } catch(TimeoutException e){
            flag = false;
        }
        Assert.assertTrue(flag);
    }

    //Test 43
    @When("A user deletes their payment information.")
    public void a_user_deletes_their_payment_information() {
        try {
            MainRunner.cartPage.deletepaymentbutton.click();
        }catch(Exception e){
            Assert.assertFalse(MainRunner.cartPage.originalcardnumberdisplay.isDisplayed());
        }
    }
    @Then("Their payment information should no longer be displayed on the page.")
    public void their_payment_information_should_no_longer_be_displayed_on_the_page() {
         Assert.assertTrue(MainRunner.cartPage.originalcardnumberdisplay.isDisplayed());

      }

    @When("The user types in address fields correctly.")
    public void the_user_types_in_address_fields_correctly() {
        wait.until(ExpectedConditions.urlToBe(MainRunner.cartPage.checkouturlpage));
        MainRunner.cartPage.firstnameinputfield.sendKeys(MainRunner.cartPage.fname);
        MainRunner.cartPage.lastnameinputfield.sendKeys(MainRunner.cartPage.lname);
        MainRunner.cartPage.cityInputfield.sendKeys(MainRunner.cartPage.city);
        MainRunner.cartPage.countryInputfield.sendKeys(MainRunner.cartPage.country);
        MainRunner.cartPage.addressinputfield.sendKeys(MainRunner.cartPage.address);
        MainRunner.cartPage.zipInputfield.sendKeys(MainRunner.cartPage.zip);

    }
    @When("They select a payment method.")
    public void they_select_a_payment_method() {
        MainRunner.cartPage.checkmarkpaymentbutton.click();
      }
    @When("They click submit payment.")
    public void they_click_submit_payment() {
        MainRunner.cartPage.submitpaymentbutton.click();

    }
    @When("They click place order.")
    public void they_click_place_order() {
        MainRunner.cartPage.placeorderbutton.click();

      }
    @Then("An order confirmation should be displayed.")
    public void an_order_confirmation_should_be_displayed() {
      Assert.assertTrue(MainRunner.cartPage.thankyoufororderconfirmation.isDisplayed());
    }

    @Then("They should be able to edit their payment information.")
    public void they_should_be_able_to_edit_their_payment_information(){
        Boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(MainRunner.cartPage.fakeeditpaymentbutton));
            Assert.assertTrue(flag);
        } catch(TimeoutException e){
            flag = false;
        }
    }


    @When("The user presses the trashcan icon.")
    public void the_user_presses_the_trashcan_icon(){
                MainRunner.cartPage.trashcanremoveitemquantityicon.click();
    }

    @Then("Their item should be deleted from the page.")
    public void their_item_should_be_deleted_from_the_page() {
        Boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(MainRunner.cartPage.headphonenamedisplay));
        } catch(TimeoutException e){
            flag = false;
            Assert.assertTrue(flag);
        }
    }

    @When("The user clicks the add quantity button.")
    public void the_user_clicks_the_add_quantity_button(){
        // Write code here that turns the phrase above into concrete actions
         MainRunner.cartPage.quantityincreasebtn.click();

    }
    @When("The user clicks the subtract quantity button.")
    public void the_user_clicks_the_subtract_quantity_button(){
        MainRunner.cartPage.quantitydecreasebtn.click();

    }
    @Then("The quantity should return to its original state.")
    public void the_quantity_should_return_to_its_original_state() {
        Assert.assertTrue(MainRunner.cartPage.headphonenamedisplay.isDisplayed());
    }
    @Then("The cart total should be accurate.")
    public void the_cart_total_should_be_accurate() {
        Assert.assertEquals(MainRunner.cartPage.totalCostofOrderDisplay.getText(),"$20.00");
        }

    @And("The user types in a {string} in first name field.")
    public void theUserTypesInAInFirstNameField(String firstName) {
    }

    @And("The user types in a {string} in last name field.")
    public void theUserTypesInAInLastNameField(String lastName) {
    }

    @And("The user types in a {string} in address{int} field.")
    public void theUserTypesInAInAddressField(String address, int addNum) {
    }

    @And("The user types in a {string} in city field.")
    public void theUserTypesInAInCityField(String city) {
    }

    @And("The user types in a {string} in state field.")
    public void theUserTypesInAInStateField(String state) {
    }

    @And("The user types in a {string} in zip field.")
    public void theUserTypesInAInZipField(String zip) {
    }

    @And("The user types in a {string} in country field.")
    public void theUserTypesInAInCountryField(String country) {
    }

    @Then("They should be notified of a needed field.")
    public void theyShouldBeNotifiedOfANeededField() {
    }
}