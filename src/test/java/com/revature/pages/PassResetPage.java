package com.revature.pages;

import com.revature.runner.MainRunner;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassResetPage {
    public PassResetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // RESET EMAIL
    @FindBy(xpath = "//input[@id='email']")
    public WebElement resetEmail;

    public void insertEmail() {
        resetEmail.sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }

    // RESET LINK BUTTON
    @FindBy(xpath = "//div[1]/form[1]/button[1]")
    public WebElement resetLinkButton;

    public void clickResetLinkButton() {
        resetLinkButton.click();
    }

    // RESET PASSWORD
    @FindBy(xpath = "//input[@id='password']")
    public WebElement resetPassword;

    // RESET BUTTON
    @FindBy(xpath = "//div[1]/form[1]/button[1]")
    public WebElement resetButton;
}
