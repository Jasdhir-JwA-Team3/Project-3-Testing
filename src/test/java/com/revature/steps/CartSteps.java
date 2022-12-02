package com.revature.steps;

import com.revature.runner.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSteps {
    WebDriverWait wait = new WebDriverWait(MainRunner.driver, Duration.ofSeconds(10));

    @Given("Once The User is logged in")
    public void once_the_user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
     }
    @Given("The User is on the home page")
    public void the_user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
     }
    @When("The user clicks the cart icon for headphones.")
    public void the_user_clicks_the_cart_icon_for_headphones() {
        // Write code here that turns the phrase above into concrete actions
     }
    @When("The user navigates to the cart page.")
    public void the_user_navigates_to_the_cart_page() {
        // Write code here that turns the phrase above into concrete actions
     }
    @Then("The product should be displayed.")
    public void the_product_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
     }
    @Then("The product should have an id of one.")
    public void the_product_should_have_an_id_of() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("The product should have a cost of twenty.")
    public void the_product_should_have_a_cost_of() {
        // Write code here that turns the phrase above into concrete actions
     }


}
