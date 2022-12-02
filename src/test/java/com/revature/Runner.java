package com.revature;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@CucumberOptions(features="src/test/resources/features", glue="com.revature.stepimplementations")

public class Runner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String webURL;
    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(Runner.driver, Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
