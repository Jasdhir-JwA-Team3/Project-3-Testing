package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//div/input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//form/button[text()='Sign In']")
    public WebElement signinButton;

    @FindBy(xpath = "//a[contains(text(),' have an account? Sign Up')]")
    public WebElement signupToRegister;

    @FindBy(xpath = "//a[contains(text(),'Reset your password')]")
    public WebElement resetPassword;
}
