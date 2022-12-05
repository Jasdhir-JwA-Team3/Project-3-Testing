package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
    public CreateProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[normalize-space()='Return to Products']")
    public WebElement returntoProductButton;
    @FindBy(xpath = "(//*[@id=\"outlined-required\"])[1]")
    public WebElement nameInput;
    @FindBy(xpath = "(//*[@id=\"outlined-required\"])[2]")
    public WebElement descriptionInput;
    @FindBy(xpath = "(//*[@id=\"outlined-required\"])[3]")
    public WebElement imageInput;
    @FindBy(xpath = "(//*[@id=\"outlined-required\"])[4]")
    public WebElement priceInput;

    @FindBy(xpath = "//button[normalize-space()='create product']")
    public WebElement createButton;
}
