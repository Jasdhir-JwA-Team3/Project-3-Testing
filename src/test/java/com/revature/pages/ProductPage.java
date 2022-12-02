package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // PRODUCT NAME
    @FindBy(xpath = "//div[2]//h1[1]")
    public WebElement getProductTile;

    // PRODUCT DESC
    @FindBy(xpath = "//div[1]/div[2]/div[3]/p[1]")
    public WebElement getProductDesc;

    // PRODUCT PRICE
    @FindBy(xpath = "//div[2]/div[3]/div[1]/div[5]//h5[1]")
    public WebElement getProductPrice;

    // PRODUCT STAR RATING
    @FindBy(xpath = "//div[2]/div[3]/div[2]/span[1]/label[5]")
    public WebElement starRating;

    public void select_star() {
        starRating.click();
    }

    // PRODUCT PRODUCT REVIEW
    @FindBy(xpath = "//textarea[@id='outlined-multiline-flexible']")
    public WebElement reviewTextarea;

    public void enter_review(String review) {
        reviewTextarea.sendKeys(review);
    }

    // SUBMIT REVIEW
    @FindBy(xpath = "//div[2]/div[3]/div[2]/div[2]/button[1]")
    public WebElement reviewButton;

    public void review_button() {
        reviewButton.click();
    }
}
