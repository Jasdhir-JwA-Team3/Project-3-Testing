package com.revature.runner;

import com.revature.pages.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@CucumberOptions(features = "src/test/resources/features", glue = "com.revature.steps", tags = "@ResetPassword")
public class MainRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static MasterPage masterPage;
    public static HomePage homePage;
    public static ProductPage productPage;
    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static UserProfilePage userProfilePage;
    public static AdminPage adminPage;
    public static CartPage cartPage;
    public static ProductModel productModel;
    public static CreateProductPage createProductPage;
    public static OrdersPage ordersPage;
    public static PassResetPage passResetPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        masterPage = new MasterPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        adminPage = new AdminPage(driver);
        createProductPage = new CreateProductPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        userProfilePage = new UserProfilePage(driver);
        productModel = new ProductModel(driver);
        cartPage = new CartPage(driver);
        ordersPage = new OrdersPage(driver);
        passResetPage = new PassResetPage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
