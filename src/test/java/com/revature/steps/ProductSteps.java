package com.revature.steps;

import com.revature.runner.MainRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.reporters.jq.Main;

import java.time.Duration;

public class ProductSteps {
    WebDriverWait wait = new WebDriverWait(MainRunner.driver, Duration.ofSeconds(10));

    // SET SCENE
    @Given("User is logged in")
    public void user_is_logged_in() {
        MainRunner.masterPage.getURL("http://localhost:3000/login");

        WebElement email = MainRunner.driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("notadmin@gmail.com");
        WebElement password = MainRunner.driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("password");
        WebElement loginButton = MainRunner.driver.findElement(By.xpath("//div[1]/form[1]/button[1]"));
        loginButton.click();

    }
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        Assert.assertEquals(MainRunner.driver.getCurrentUrl(), "http://localhost:3000/");
    }

    // CHECK PRODUCT
    @Then("User should see products")
    public void user_should_see_products() {
        Assert.assertTrue(MainRunner.homePage.product_list());
    }

    // VIEW PRODUCT
    @When("User views {string}")
    public void user_views(String product) {
        switch (product) {
            case "headphone" -> {
                MainRunner.homePage.hover_headphone();
                WebElement headphoneViewOption = wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.selectHeadphone));
                headphoneViewOption.click();
            }
            case "teeshirt" -> {
                MainRunner.homePage.hover_teeshirt();
                WebElement teeshirtViewOption = wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.selectShirt));
                teeshirtViewOption.click();
            }
            case "shopping bag" -> {
                MainRunner.homePage.hover_bag();
                WebElement bagViewOption = wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.selectBag));
                bagViewOption.click();
            }
            case "hat" -> {
                MainRunner.homePage.hover_hat();
                WebElement hatViewOption = wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.selectHat));
                hatViewOption.click();
            }
            case "coat" -> {
                MainRunner.homePage.hover_coat();
                WebElement coatViewOption = wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.selectCoat));
                coatViewOption.click();
            }
        }
    }
    @When("Expands the product")
    public void expands_the_product() {
        MainRunner.homePage.expand_button();
    }
    @Then("User should be on {string}")
    public void userShouldBeOn(String productUrl) {
        wait.until(ExpectedConditions.urlToBe(productUrl));
        Assert.assertEquals(MainRunner.driver.getCurrentUrl(), productUrl);
    }
    @And("User confirms name {string}")
    public void user_confirms_name(String name) {
        Assert.assertEquals(MainRunner.productPage.getProductTile.getText(), name);
    }
    @And("User confirms description {string}")
    public void user_confirms_description(String description) {
        Assert.assertEquals(MainRunner.productPage.getProductDesc.getText(), description);
    }
    @And("User confirms prices {string}")
    public void user_confirms_prices(String price) {
        Assert.assertEquals(MainRunner.productPage.getProductPrice.getText(), price);
    }

    // FILTER PRODUCT
    @When("User search {string}")
    public void userSearch(String product) {
        MainRunner.homePage.enter_filteredSearch(product);
        MainRunner.homePage.search_button();
    }
    @Then("Product should be visible")
    public void productShouldBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.productExist));
        Assert.assertTrue(MainRunner.homePage.product_exist());
    }
    @Then("Product should not be visible")
    public void productShouldNotBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.productNotExist));
        Assert.assertTrue(MainRunner.homePage.product_not_exist());
    }

    // CREATE PRODUCT REVIEW
    @And("User selects star rating")
    public void userSelectsStarRating() {
        MainRunner.productModel.select_star();
    }
    @And("User enter review {string}")
    public void userEnterReview(String review) {
        MainRunner.productModel.reviewTextarea.sendKeys(review);
    }
    @Then("User clicks {string} button")
    public void userClicksButton(String arg0) {
        WebElement reviewButton = wait.until(ExpectedConditions.visibilityOf(MainRunner.productModel.reviewButton));
        reviewButton.click();
    }

    @When("User finds product review")
    public void userFindsProductReview() {
        Assert.assertTrue(MainRunner.productModel.review_exist());
    }
    @Then("Product review should be deleted")
    public void productReviewShouldBeDeleted() {
        wait.until(ExpectedConditions.visibilityOf(MainRunner.productModel.reviewerName));
        WebElement deleteReview = wait.until(ExpectedConditions.visibilityOf(MainRunner.productModel.deleteButton));
        deleteReview.click();
    }
}
