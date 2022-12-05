package com.revature.pages;

import com.revature.runner.MainRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[contains(text(),'REGISTER')]")
    public WebElement registerLink;

    @FindBy(xpath = "//strong[contains(text(),'SIGN IN')]")
    public WebElement signInLink;

    @FindBy(xpath = "//strong[contains(text(),'PROFILE')]")
    public WebElement profileLink;

    @FindBy(xpath = "//strong[contains(text(),'LOGOUT')]")
    public WebElement logoutLink;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement modeChanger;

    // CHECK PRODUCT
    @FindBy(xpath = "//div[1]/div[3]/div[1]/div[1]")
    public WebElement productExist;

    public boolean product_exist() {
        return productExist.isDisplayed();
    }

    @FindBy(xpath = "//div[@id='root']/div[2]")
    public WebElement productNotExist;

    public boolean product_not_exist() {
        return productNotExist.isDisplayed();
    }

    // VIEW PRODUCT LIST
    public boolean product_list() {
        boolean productList = MainRunner.driver.findElement(By.xpath("//div[@id='root']/div[3]")).isDisplayed();
        return productList;
    }

    // PRODUCT SEARCH TEXT BOX
    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement productSearchBox;

    public void enter_filteredSearch(String product) {
        productSearchBox.sendKeys(product);
    }

    // PRODUCT SEARCH BUTTON
    @FindBy(xpath = "//div[1]/div[2]/div[1]/button[1]")
    public WebElement searchButton;

    public void search_button() {
        searchButton.click();
    }

    // PRODUCT CANCEL BUTTON
    @FindBy(xpath = "//div[2]/div[1]/button[2]")
    public WebElement cancelButton;

    public void cancel_button() {
        cancelButton.click();
    }

    // SEARCH PRODUCT TITLE
    @FindBy(xpath = "//div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/h5[1]")
    public WebElement getSearchProduct;

    // HOVER OVER PRODUCT
    @FindBy(xpath = "//div[@id='root']/div[3]/div[1]")
    public WebElement hoverHeadphone;

    public void hover_headphone() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(hoverHeadphone).build();
        mouseOver.perform();
    }

    @FindBy(xpath = "//div[@id='root']/div[3]/div[2]")
    public WebElement hoverTeeshirt;

    public void hover_teeshirt() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(hoverTeeshirt).build();
        mouseOver.perform();
    }

    @FindBy(xpath = "//div[@id='root']/div[3]/div[3]")
    public WebElement hoverBag;

    public void hover_bag() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(hoverBag).build();
        mouseOver.perform();
    }

    @FindBy(xpath = "//div[@id='root']/div[3]/div[4]")
    public WebElement hoverHat;

    public void hover_hat() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(hoverHat).build();
        mouseOver.perform();
    }

    @FindBy(xpath = "//div[@id='root']/div[3]/div[5]")
    public WebElement hoverCoat;

    public void hover_coat() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(hoverCoat).build();
        mouseOver.perform();
    }

    // PRODUCT VIEW BUTTON(S)
    @FindBy(xpath = "//div[3]/div[1]/div[1]/div[1]/div[2]/div[1]")
    public WebElement selectHeadphone;

    public void view_headphone() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(selectHeadphone).build();
        mouseOver.perform();
    }

    @FindBy(xpath = "//div[3]/div[2]/div[1]/div[1]/div[2]/div[1]")
    public WebElement selectShirt;

    public void view_shirt() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(selectShirt).build();
        mouseOver.perform();
    }

    @FindBy(xpath = "//div[3]/div[3]/div[1]/div[1]/div[2]/div[1]")
    public WebElement selectBag;

    public void view_bag() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(selectBag).build();
        mouseOver.perform();
    }

    @FindBy(xpath = "//div[3]/div[4]/div[1]/div[1]/div[2]/div[1]")
    public WebElement selectHat;

    public void view_hat() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(selectHat).build();
        mouseOver.perform();
    }

    @FindBy(xpath = "//div[3]/div[5]/div[1]/div[1]/div[2]/div[1]")
    public WebElement selectCoat;

    public void view_coat() {
        Actions builder = new Actions(MainRunner.driver);
        Action mouseOver = builder.moveToElement(selectCoat).build();
        mouseOver.perform();
    }

    //EDIT PRODUCTS
    @FindBy(xpath = "//strong[normalize-space()='EDIT PRODUCTS']")
    public WebElement editProducts;

    // EXPAND PRODUCT DETAILS
    @FindBy(xpath = "//div[2]/div[3]/div[1]/h2[1]/button[1]")
    public WebElement viewProductButton;

    public void expand_button() {
        viewProductButton.click();
    }

    // PRODUCT NAME
    @FindBy(xpath = "//div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/h5[1]")
    public WebElement headphoneTile;

    @FindBy(xpath = "//div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/h5[1]")
    public WebElement teeshirtTile;

    @FindBy(xpath = "//div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/h5[1]")
    public WebElement shoppingbagTile;

    @FindBy(xpath = "//div[1]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/h5[1]")
    public WebElement baseballcapTile;

    @FindBy(xpath = "//div[1]/div[3]/div[5]/div[1]/div[2]/div[1]/div[1]/h5[1]")
    public WebElement coatTile;

    // PRODUCT DESC
    @FindBy(xpath = "//div[1]/div[3]/div[1]/div[1]/div[2]/p[1]")
    public WebElement headphoneDecs;

    @FindBy(xpath = "//div[1]/div[3]/div[2]/div[1]/div[2]/p[1]")
    public WebElement teeshirtDecs;

    @FindBy(xpath = "//div[1]/div[3]/div[3]/div[1]/div[2]/p[1]")
    public WebElement shoppingDecs;

    @FindBy(xpath = "//div[1]/div[3]/div[4]/div[1]/div[2]/p[1]")
    public WebElement baseballcapDecs;

    @FindBy(xpath = "//div[1]/div[3]/div[5]/div[1]/div[2]/p[1]")
    public WebElement coatDecs;

    // PRODUCT PRICE
    @FindBy(xpath = "//div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h6[1]")
    public WebElement headphonePrice;

    @FindBy(xpath = "//div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/h6[1]")
    public WebElement teeshirtPrice;

    @FindBy(xpath = "//div[3]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/h6[1]")
    public WebElement shoppingbagPrice;

    @FindBy(xpath = "//div[3]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/h6[1]")
    public WebElement baseballcapPrice;

    @FindBy(xpath = "//div[3]/div[5]/div[1]/div[2]/div[1]/div[2]/div[1]/h6[1]")
    public WebElement coatPrice;

    // SUBMIT REVIEW
    @FindBy(xpath = "//div[2]/div[3]/div[2]/div[2]/button[1]")
    public WebElement reviewButton;

    public void review_button() {
        reviewButton.click();
    }

}
