package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage {

    public UserProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement updateButton;

    @FindBy(xpath = "//input[@id='deactivate']")
    public WebElement deactivateInput;

    @FindBy(xpath = "//button[text()='Deactivate']")
    public WebElement deactivateButton;

    @FindBy(xpath = "//input[@id='cardNumber']")
    public WebElement cardNumberInput;

    @FindBy(xpath = "//input[@id='expDate']")
    public WebElement expDateInput;

    @FindBy(xpath = "//input[@id='ccv']")
    public WebElement ccvInput;

    @FindBy(xpath = "//button[text()='Add Payment']")
    public WebElement addPaymentButton;

    @FindBy(xpath = "//table/tbody/tr[last()]")
    public WebElement newestPayment;

}
