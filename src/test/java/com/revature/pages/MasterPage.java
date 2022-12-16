package com.revature.pages;

import com.revature.runner.MainRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MasterPage {
    public MasterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String getEmailText = "";

    // GET URL
    public void getURL(String pageURL) {
        MainRunner.driver.get(pageURL);
    }

    // GET ALERT
    public String getAlert() {
        return MainRunner.driver.switchTo().alert().getText();
    }

    public void getEmail() {
        getURL("https://emailtemp.org/en");
    }

    @FindBy(xpath = "//input[@id='trsh_mail']")
    public WebElement getEmail;

    public void copyEmail() throws InterruptedException {
        getEmail();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        getEmailText = getEmail.getText();
        WebDriverWait wait = new WebDriverWait(MainRunner.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(getEmail, getEmailText));
        WebElement copyEmail = MainRunner.driver.findElement(org.openqa.selenium.By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"));
        copyEmail.click();
    }

    @FindBy(xpath = "//section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/a[1]")
    public WebElement clickEmail;

    @FindBy(xpath = "//section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")
    public WebElement refreshEmail;


    public void getLink() {
        // go inside iframe to read email
        MainRunner.driver.switchTo().frame("myIframe");
        WebElement emailBody = MainRunner.driver.findElement(By.xpath("//body"));
        String emailBodyText = emailBody.getText();
        String[] emailText = emailBodyText.split("\n");
        String specificString = null;

        System.out.println("Email text: " + Arrays.toString(emailText));

        for (String s : emailText) {
            if (s.contains("http://localhost:3000/reset-password/")) {
                specificString = s;
                MainRunner.driver.get(specificString);
            }
        }

        MainRunner.driver.switchTo().defaultContent();
    }
}