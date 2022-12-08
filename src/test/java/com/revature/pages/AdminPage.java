package com.revature.pages;

import com.revature.runner.MainRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[normalize-space()='Back to Products']")
    public WebElement backtoProductButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/button")
    public WebElement createProduct;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    public WebElement updateProduct;

    @FindBy(xpath ="(//div/button)[7]")
    public WebElement productToClick;
    @FindBy(xpath = "//h3")
    public WebElement nameH3;
    @FindBy(xpath = "//h3/following-sibling::img")
    public WebElement imageLink;
    @FindBy(xpath = "//h4")
    public WebElement priceH4;
    @FindBy(xpath = "//h5")
    public WebElement descriptionH5;
}
