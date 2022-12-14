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
        Alert alert = null;
        try {
            alert = MainRunner.wait.until(ExpectedConditions.alertIsPresent());
            MainRunner.driver.switchTo().alert();
            String expectedAlertTest = missing + " cannot be empty.";
            Assert.assertEquals(alert.getText(), expectedAlertTest);
            alert.accept();
        } catch (org.openqa.selenium.TimeoutException e) {
            Assert.assertNotNull(alert);
        }
    }

    @Then("Admin clicks update")
    public void adminClicksUpdate() {
        MainRunner.adminPage.updateProduct.click();
        MainRunner.driver.navigate().refresh();
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminPage.backtoProductButton));
    }

    @Then("Product should update name with {string}")
    public void productShouldUpdateNameWith(String name) {
        String curName = MainRunner.adminPage.nameH3.getText();
        Assert.assertEquals(curName, name);
    }

    @And("description with {string}")
    public void descriptionWith(String description) {
        String curDesc = MainRunner.adminPage.descriptionH5.getText();
        Assert.assertEquals(curDesc, description);
    }

    @And("image with {string}")
    public void imageWith(String image) {
        String curLink = MainRunner.adminPage.imageLink.getAttribute("src");
        Assert.assertEquals(curLink, image);

    }

    @And("price with {string}")
    public void priceWith(String price) {
        String curPrice = MainRunner.adminPage.priceH4.getText();
        float intPrice = Float.parseFloat(price);
        price = String.format("$%-10.2f",intPrice);
        Assert.assertEquals(curPrice, price.trim());
    }

    @And("Admin clicks on a product")
    public void adminClicksOnAProduct() {
        MainRunner.adminPage.productToClick.click();
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminPage.backtoProductButton));
    }

    @And("Admin fills the description {string}")
    public void adminFillsTheDescription(String description) {
        adminFillsInImageURL(description);
    }

    @And("Admin fills the image URL {string}")
    public void adminFillsTheImageURL(String image) {
        adminFillsInDescription(image);
    }

    @When("Admin clicks on the first product")
    public void admin_clicks_on_the_first_product() {
        MainRunner.adminPage.listOfItemsOnPage = MainRunner.driver.findElements(By
                .xpath("//div/div[3]/div/button"));
        MainRunner.adminPage.numOfItems = MainRunner.adminPage.listOfItemsOnPage.size();
        MainRunner.adminPage.firstItem.click();
        MainRunner.adminPage.urlOfFirstItem = MainRunner.driver.getCurrentUrl();
    }
    @When("admin clicks delete product")
    public void admin_clicks_delete_product() {
        WebElement deleteButton =MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.driver.findElement(By
                .xpath("//div[3]/button[contains(text(),'Delete')]"))));
        deleteButton.click();
    }
    @Then("the product should no longer be available on the page")
    public void the_product_should_no_longer_be_available_on_the_page() throws InterruptedException {
        MainRunner.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/admin/products/1"));
        MainRunner.adminPage.firstItem = MainRunner.driver.findElement(By.xpath("//div/div[3]/div[1]/button"));
        MainRunner.adminPage.firstItem.click();
        String currentURL = MainRunner.driver.getCurrentUrl();
        Assert.assertFalse(currentURL.equals(MainRunner.adminPage.urlOfFirstItem));
        MainRunner.adminPage.listOfItemsOnPage = MainRunner.driver.findElements(By
                .xpath("//div/div[3]/div/button"));
        int currentNumOfItems = MainRunner.adminPage.listOfItemsOnPage.size();
        Assert.assertFalse(currentNumOfItems == MainRunner.adminPage.numOfItems);
    }
}


