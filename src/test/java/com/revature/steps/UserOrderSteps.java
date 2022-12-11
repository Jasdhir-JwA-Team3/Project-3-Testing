package com.revature.steps;

import com.revature.runner.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UserOrderSteps {
    WebDriverWait wait = new WebDriverWait(MainRunner.driver, Duration.ofSeconds(1));
    @When("User clicks orders button")
    public void userClickOrderButton() {
        MainRunner.homePage.ordersButton.click();
    }

    @Then("The user is taken to the orders page")
    public void userIsTakenToTheOrdersPage() {
        Boolean url = MainRunner.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/orders"));
        Assert.assertTrue(url);
    }

    @Then("User sees information about previous orders they've made")
    public void user_sees_information_about_previous_orders_they_ve_made() {
        MainRunner.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/orders"));
        Boolean flag = false;
        MainRunner.ordersPage.listOfOrders = MainRunner.driver.findElements(By.xpath("//div/div[4]/div"));
        if(MainRunner.ordersPage.listOfOrders.size() > 0) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }
    @When("User navigates to Orders page")
    public void user_navigates_to_orders_page() {
        MainRunner.driver.findElement(By.xpath("//strong[contains(text(),'ORDERS')]")).click();
        //MainRunner.wait.until(ExpectedConditions.urlToBe("http://localhost:3000/orders"));
    }
    @Then("User sees the headphones order")
    public void user_sees_the_headphones_order() {
        Boolean flag = true;
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div/div[4]/div"),0));
        MainRunner.ordersPage.listOfOrders = MainRunner.driver.findElements(By.xpath("//div/div[4]/div"));
        try{
            String headphones = MainRunner.ordersPage.listOfOrders.get(0).findElement(
                    By.xpath("//div/div[4]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/a/p")).getText();
            if(!headphones.equals("Headphones")) {
                flag = false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        Assert.assertTrue(flag);
    }

}
