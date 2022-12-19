package com.revature.steps;

import com.revature.runner.MainRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.reporters.jq.Main;

import java.time.Duration;
import java.util.Random;

public class UserSteps {
    WebDriverWait wait = new WebDriverWait(MainRunner.driver, Duration.ofSeconds(1));
    WebDriverWait wait10 = new WebDriverWait(MainRunner.driver, Duration.ofSeconds(10));
    private static String[] userInfo = new String[2];
    private String saveCardNumber;
    private int numOfPayments;

    @Given("user opens Home page")
    public void user_opens_home_page() {
        MainRunner.masterPage.getURL("http://localhost:3000/");
    }
    @When("user clicks sign in")
    public void user_clicks_sign_in() {
        wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.signInLink));
        MainRunner.homePage.signInLink.click();
    }
    @When("user enters email {string}")
    public void user_enters_email(String string) {
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
        if (string.equals("none")) {
            string = "";
        }
        MainRunner.loginPage.emailInput.sendKeys(string);
    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
        if (string.equals("none")) {
            string = "";
        }
        MainRunner.loginPage.passwordInput.sendKeys(string);
    }
    @Then("user successfully logs in")
    public void user_successfully_logs_in() {
        MainRunner.loginPage.signinButton.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        Assert.assertEquals(MainRunner.driver.getCurrentUrl(), "http://localhost:3000/");
        
    }
    @Then("user is unable to log in")
    public void user_is_unable_to_log_in() {
        MainRunner.loginPage.signinButton.click();
        boolean flag = true;
        try{
            wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
            Assert.assertTrue(flag);
        }
        catch (TimeoutException e) {
            flag = false;
        }
        Assert.assertFalse(flag);
    }

    @When("user clicks Don't have an account")
    public void user_clicks_don_t_have_an_account() {
        wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.signupToRegister));
        MainRunner.loginPage.signupToRegister.click();
    }
    @When("user clicks they already have an account")
    public void user_clicks_they_already_have_an_account() {
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/register"));
        MainRunner.registerPage.registerToLogin.click();
    }
    @Then("user should be back on the login page")
    public void user_should_be_back_on_the_login_page() {
        Assert.assertEquals(MainRunner.driver.getCurrentUrl(), "http://localhost:3000/login");
    }

    @When("user clicks Register link")
    public void user_clicks_register_link() {
        MainRunner.homePage.registerLink.click();
    }
    @When("user enters valid registration info {string}, {string}, {string}")
    public void user_enters_valid_registration_info(String firstName, String lastName, String password) {
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/register"));
        MainRunner.registerPage.firstNameinput.sendKeys(firstName);
        MainRunner.registerPage.lastNameinput.sendKeys(lastName);
        String[] signupInfo = UserHelper.createRandomString(1);
        signupInfo[0] += "@email.com";
        userInfo[0] = signupInfo[0];
        MainRunner.registerPage.emailInput.sendKeys(signupInfo[0]);
        userInfo[1] = password;
        MainRunner.registerPage.passwordInput.sendKeys(password);
        MainRunner.registerPage.signupButton.click();
    }
    @Then("user should be registered and on log in page")
    public void user_should_be_registered_and_on_log_in_page() {
        boolean flag = true;
        try{
            wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
        }
        catch (TimeoutException e) {
            flag = false;
        }
        Assert.assertTrue(flag);
    }

    @When("user enters invalid registration info {string}, {string}, {string}, {string}")
    public void user_enters_invalid_registration_info(String firstName, String lastName, String email, String password) {
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/register"));

        if(firstName.equals("none"))
            firstName = "";
        MainRunner.registerPage.firstNameinput.sendKeys(firstName);

        if(lastName.equals("none"))
            lastName = "";
        MainRunner.registerPage.lastNameinput.sendKeys(lastName);

        String[] signupInfo;
        signupInfo = UserHelper.createRandomString(1);
        switch (email) {
            case "valid email" -> signupInfo[0] += "@email.com";
            case "invalid email" -> signupInfo[0] += "+* .@email.com";
            case "none" -> signupInfo[0] = "";
        }
        MainRunner.registerPage.emailInput.sendKeys(signupInfo[0]);

        if(password.equals("none"))
            password = "";
        MainRunner.registerPage.passwordInput.sendKeys(password);

        MainRunner.registerPage.signupButton.click();
    }
    @Then("user should be not be registered or on log in page")
    public void user_should_be_not_be_registered_or_on_log_in_page() {
        boolean flag = false;
        try{
            wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
        }
        catch (TimeoutException e) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    @When("user logs in")
    public void user_logs_in() {
        MainRunner.masterPage.getURL("http://localhost:3000/");
        wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.signInLink));
        MainRunner.homePage.signInLink.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
        MainRunner.loginPage.emailInput.sendKeys(userInfo[0]);
        MainRunner.loginPage.passwordInput.sendKeys(userInfo[1]);
        MainRunner.loginPage.signinButton.click();
    }
    @When("user clicks profile")
    public void user_clicks_profile() {
        wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.profileLink));
        MainRunner.homePage.profileLink.click();
    }
    @When("User enters update information {string}, {string}, {string}")
    public void user_enters_update_information(String firstName, String lastName, String password) {
        if(firstName.equals("none"))
            firstName = "";
        MainRunner.userProfilePage.firstNameInput.clear();
        MainRunner.userProfilePage.firstNameInput.sendKeys(firstName);
        if(lastName.equals("none"))
            lastName = "";
        MainRunner.userProfilePage.lastNameInput.clear();
        MainRunner.userProfilePage.lastNameInput.sendKeys(lastName);
        if(password.equals("none"))
            password = "";
        MainRunner.userProfilePage.passwordInput.sendKeys(password);
    }
    @Then("user clicks update and has successfully updates their information")
    public void user_clicks_update_and_has_successfully_updates_their_information() {
        MainRunner.userProfilePage.updateButton.click();
        boolean flag = true;
        try{
            WebElement popUp = wait.until(ExpectedConditions.visibilityOf(MainRunner.driver.findElement(By
                    .xpath("//div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]"))));
            if(!popUp.getText().equals("You've successfully updated your profile!")) {
                flag = false;
            }
        }
        catch (StaleElementReferenceException e) {
            WebElement popUp = wait.until(ExpectedConditions.visibilityOf(MainRunner.driver.findElement(By
                    .xpath("//div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]"))));
            if(!popUp.getText().equals("You've successfully updated your profile!")) {
                flag = false;
            }
        }
        catch (TimeoutException e) {
            flag = false;
        }
        finally {
            MainRunner.userProfilePage.passwordInput.clear();
            MainRunner.userProfilePage.passwordInput.sendKeys(userInfo[1]);
            MainRunner.userProfilePage.updateButton.click();
        }
        Assert.assertTrue(flag);
    }
    @Then("user clicks update and has fails to update their information")
    public void user_clicks_update_and_has_fails_to_update_their_information() {
        MainRunner.userProfilePage.updateButton.click();
        boolean flag = true;
        try{
            WebElement popUp = wait.until(ExpectedConditions.visibilityOf(MainRunner.driver.findElement(By
                    .xpath("//div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]"))));
            if(!popUp.getText().equals("You've successfully updated your profile!")) {
                flag = false;
            }
        }
        catch (StaleElementReferenceException e) {
            WebElement popUp = wait.until(ExpectedConditions.visibilityOf(MainRunner.driver.findElement(By
                    .xpath("//div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]"))));
            if(!popUp.getText().equals("You've successfully updated your profile!")) {
                flag = false;
            }
        }
        catch (TimeoutException e) {
            flag = false;
        }
        finally {
            MainRunner.userProfilePage.passwordInput.clear();
            MainRunner.userProfilePage.passwordInput.sendKeys(userInfo[1]);
            MainRunner.userProfilePage.updateButton.click();
        }
        Assert.assertFalse(flag);
    }


    @When("user types deactivate and deactivates account")
    public void user_types_deactivate_and_deactivates_account() {
        MainRunner.userProfilePage.deactivateInput.sendKeys("deactivate");
        MainRunner.userProfilePage.deactivateButton.click();
    }
    @Then("user should be logged out and not able to log back in")
    public void user_should_be_logged_out_and_not_able_to_log_back_in() {
        boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.logoutLink));
        }
        catch (TimeoutException e) {
            flag = false;
        }
        Assert.assertFalse(flag);
    }

    @When("user logs in to edit card info")
    public void user_logs_in_to_edit_card_info() {
        MainRunner.masterPage.getURL("http://localhost:3000/");
        wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.signInLink));
        MainRunner.homePage.signInLink.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
        MainRunner.loginPage.emailInput.sendKeys("project03test@gmail.com");
        MainRunner.loginPage.passwordInput.sendKeys("Password1*");
        MainRunner.loginPage.signinButton.click();
    }
    @When("User enters payment information {string}, {string}, {string}")
    public void user_enters_payment_information(String cardNumber, String expDate, String ccv) {
        numOfPayments = MainRunner.driver.findElements(By.xpath("//table/tbody/tr")).size();
        saveCardNumber = cardNumber;
        MainRunner.userProfilePage.cardNumberInput.sendKeys(cardNumber);
        MainRunner.userProfilePage.expDateInput.sendKeys(expDate);
        MainRunner.userProfilePage.ccvInput.sendKeys(ccv);
        MainRunner.userProfilePage.addPaymentButton.click();

    }
    @Then("user clicks add payment and creates a new payment method")
    public void user_clicks_add_payment_and_creates_a_new_payment_method() {
        boolean flag = true;
        try{
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table/tbody/tr"), numOfPayments));
            WebElement popUp = MainRunner.driver.findElement(By.xpath(
                    "//div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]"));
            if(!popUp.getText().equals("You've successfully added your payment method!")) {
                flag = false;
            }
            numOfPayments = MainRunner.driver.findElements(By.xpath("//table/tbody/tr")).size();
        }
        catch (TimeoutException e) {
            flag = false;
        }
        Assert.assertTrue(flag);
    }
    @Then("user clicks add payment and is unable to create a new payment method")
    public void user_clicks_add_payment_and_is_unable_to_create_a_new_payment_method() {
        boolean flag = true;
        try{
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table/tbody/tr"), numOfPayments));
            WebElement popUp = MainRunner.driver.findElement(By.xpath(
                    "//div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]"));
            if(!popUp.getText().equals("You've successfully added your payment method!")) {
                flag = false;
            }
            numOfPayments = MainRunner.driver.findElements(By.xpath("//table/tbody/tr")).size();
        }
        catch (TimeoutException e) {
            flag = false;
        }
        Assert.assertFalse(flag);
    }

    @Then("user is on light mode")
    public void user_is_on_light_mode() {
        String backgroundColor = MainRunner.driver.findElement(By.xpath("//body")).
                getCssValue("background-color");
        Assert.assertEquals(backgroundColor, "rgba(255, 255, 255, 1)");
        MainRunner.homePage.modeChanger.click();
    }
    @When("user clicks to switch to dark mode")
    public void user_clicks_to_switch_to_dark_mode() {
        MainRunner.homePage.modeChanger.click();
    }
    @Then("user is on dark mode")
    public void user_is_on_dark_mode() {
        String backgroundColor = MainRunner.driver.findElement(By.xpath("//body")).
                getCssValue("background-color");
        Assert.assertEquals(backgroundColor, "rgba(18, 18, 18, 1)");
    }

    @When("user1 logs in")
    public void user1_logs_in() {
        user_logs_in_to_edit_card_info();
    }
    @When("user1 changes appearance to dark mode")
    public void user1_changes_appearance_to_dark_mode() {
        MainRunner.homePage.doubleClickModeChanger();
    }
    @When("user logs out")
    public void user_logs_out() {
       wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.logoutLink));
        MainRunner.homePage.logoutLink.click();
    }
    @When("user2 logs in")
    public void user2_logs_in() {
        wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.signInLink));
        MainRunner.homePage.signInLink.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
        MainRunner.loginPage.emailInput.sendKeys("notadmin@gmail.com");
        MainRunner.loginPage.passwordInput.sendKeys("password");
        MainRunner.loginPage.signinButton.click();
    }
    @Then("user2 should have light mode appearance")
    public void user2_should_have_light_mode_appearance() {
        String backgroundColor = MainRunner.driver.findElement(By.xpath("//body")).
                getCssValue("background-color");
        Assert.assertEquals(backgroundColor, "rgba(255, 255, 255, 1)");
    }

    // RESET PASSWORD
    @Given("user created an account")
    public void user_created_an_account() throws InterruptedException {
        MainRunner.masterPage.copyEmail();
        MainRunner.masterPage.getURL("http://localhost:3000/");
        wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.registerLink));
        MainRunner.homePage.registerLink.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/register"));
        MainRunner.registerPage.firstNameinput.sendKeys("Faked");
        MainRunner.registerPage.lastNameinput.sendKeys("UserBot");
        MainRunner.registerPage.emailInput.sendKeys(Keys.chord(Keys.CONTROL, "v"));
        MainRunner.registerPage.passwordInput.sendKeys("FakeBot291@");
        WebElement signUpButton = MainRunner.driver.findElement(By.xpath("//button[text()='Sign Up']"));
        signUpButton.click();
    }

    @And("user clicks forgot password")
    public void userClicksForgotPassword() {
        WebElement forgotPassword = wait.until(ExpectedConditions.visibilityOf(MainRunner.loginPage.resetPassword));
        forgotPassword.click();
    }

    @When("user resets password")
    public void userResetsPassword() {
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/forgot-password"));
        MainRunner.passResetPage.insertEmail();
        MainRunner.passResetPage.clickResetLinkButton();
    }

    @And("user clicks link in email for {string}")
    public void userClicksLinkInEmail(String password) throws InterruptedException {
        MainRunner.masterPage.getEmail();
        WebElement clickRefresh = wait10.until(ExpectedConditions.visibilityOf(MainRunner.masterPage.refreshEmail));
        clickRefresh.click();
        WebElement clickEmail = wait10.until(ExpectedConditions.visibilityOf(MainRunner.masterPage.clickEmail));
        clickEmail.click();
        MainRunner.masterPage.getLink();
        wait.until(ExpectedConditions.visibilityOf(MainRunner.passResetPage.resetPassword));
        MainRunner.passResetPage.resetPassword.sendKeys(password);
        WebElement resetPasswordButton = wait10.until(ExpectedConditions.visibilityOf(MainRunner.passResetPage.resetButton));
        resetPasswordButton.click();
    }

    @Then("user should be able to log in with new password")
    public void user_should_be_able_to_log_in_with_new_password() {
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
        MainRunner.registerPage.emailInput.sendKeys(Keys.chord(Keys.CONTROL, "v"));
        MainRunner.registerPage.passwordInput.sendKeys("FakeBot426@");
        MainRunner.loginPage.signinButton.click();
    }
}
