package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductModel {
    public ProductModel(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // CHECK REVIEW
    @FindBy(xpath = "//div[2]/div[3]/div[1]/div[6]/div[1]/div[1]")
    public WebElement reviewExist;

    public boolean review_exist() {
        return reviewExist.isDisplayed();
    }

    // CHECK DELETED REVIEW
    @FindBy(xpath = "//p[contains(text(),'No reviews..')]")
    public WebElement reviewDeleted;

    // PRODUCT NAME
    @FindBy(xpath = "//h2[@id='customized-dialog-title']")
    public WebElement getProductTile;

    // PRODUCT DESC
    @FindBy(xpath = "//div[2]/div[3]/div[1]/div[3]/p[1]")
    public WebElement getProductDesc;

    // PRODUCT PRICE
    @FindBy(xpath = "//div[2]/div[3]/div[1]/div[2]/p[1]")
    public WebElement getProductPrice;

    // PRODUCT STAR RATING
    @FindBy(xpath = "//div[2]/div[3]/div[1]/div[5]/span[1]/label[5]")
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
    @FindBy(xpath = "//div[2]/div[3]/div[1]/div[5]/div[2]/button[1]")
    public WebElement reviewButton;

    // DELETE BUTTON
    @FindBy(xpath = "//div[2]/div[3]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
    public WebElement deleteButton;

    // REVIEWER NAME
    @FindBy(xpath = "//p[contains(text(),'notingham')]")
    public WebElement reviewerName;
}
