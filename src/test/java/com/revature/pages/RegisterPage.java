package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameinput;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameinput;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Sign Up']")
    public WebElement signupButton;

    @FindBy(xpath = "//a[text()='Already have an account? Sign in']")
    public WebElement registerToLogin;


}
