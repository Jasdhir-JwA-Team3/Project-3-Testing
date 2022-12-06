package com.revature.steps;

import com.revature.runner.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UserOrderSteps {
    @When("User clicks orders button")
    public void userClickOrderButton() {
        MainRunner.homePage.ordersButton.click();
    }

    @Then("The user is taken to the orders page")
    public void userIsTakenToTheOrdersPage() {
        Boolean url = MainRunner.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/orders"));
        Assert.assertTrue(url);
    }

}
