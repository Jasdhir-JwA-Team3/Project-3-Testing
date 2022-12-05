package com.revature.steps;

import com.revature.pages.HomePage;
import com.revature.runner.MainRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.reporters.jq.Main;

public class AdminSteps {
    @Given("Admin is logged in")
    public void adminIsLoggedIn() {
        MainRunner.masterPage.getURL("http://localhost:3000/login");
        WebElement email = MainRunner.driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("testuser@gmail.com");
        WebElement password = MainRunner.driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("password");
        WebElement loginButton = MainRunner.driver.findElement(By.xpath("//div[1]/form[1]/button[1]"));
        loginButton.click();
    }

    @And("Admin is on the home page")
    public void adminIsOnTheHomePage() {
        MainRunner.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        Assert.assertEquals(MainRunner.driver.getCurrentUrl(), "http://localhost:3000/");
    }

    @When("Admin clicks edit products")
    public void adminClicksEditProducts() {
        MainRunner.homePage.editProducts.click();
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminPage.createProduct));
    }

    @And("Admin clicks on create new product")
    public void adminClicksOnCreateNewProduct() {
        MainRunner.adminPage.createProduct.click();
        MainRunner.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/admin/createproduct"));
    }

    @And("Admin fills in name {string}")
    public void adminFillsInName(String productName) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.createProductPage.returntoProductButton));
        MainRunner.createProductPage.nameInput.sendKeys(productName);
    }

    @And("Admin fills in description {string}")
    public void adminFillsInDescription(String description) {
        MainRunner.createProductPage.descriptionInput.sendKeys(description);
    }

    @And("Admin fills in image URL {string}")
    public void adminFillsInImageURL(String image) {
        MainRunner.createProductPage.imageInput.sendKeys(image);
    }

    @And("Admin fills in price {string}")
    public void adminFillsInPrice(String price) {
        MainRunner.createProductPage.priceInput.sendKeys(price);
    }

    @Then("Admin clicks create product")
    public void adminClicksCreateProduct() {
        MainRunner.createProductPage.createButton.click();
    }

    @Then("Product screen should be up")
    public void productScreenShouldBeUp() {
       WebElement atProductPage = MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminPage.backtoProductButton));
       Assert.assertNotNull(atProductPage);
    }

    @Then("Notification for missing {string} should appear")
    public void notificationForMissingShouldAppear(String missing) {
        Alert alert = MainRunner.wait.until(ExpectedConditions.alertIsPresent());
        String expectedAlert = missing + " cannot be blank.";
        Assert.assertEquals(alert.getText(), expectedAlert);
    }
}
