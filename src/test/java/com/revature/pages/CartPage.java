package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//body/div[@id=" +
            "'root']/div[@class='sc-himrzO " +
            "gFAZYV']/div[1]/div[1]/div[1]/div[1]")
        public WebElement headphonecart;

    String actualUrl = "http://localhost:3000/cart";

    @FindBy(xpath="//*[name()='path' and contains(@d,'M15.55 13c')]")
    public WebElement cartTab;

    @FindBy(xpath="//span[@class='sc-hAZoDl gYrcjl']")
    public WebElement headphonename;

    @FindBy(xpath="//b[normalize-space()='ID:']")
    public WebElement headphoneID;


    @FindBy(xpath="//div[@class='sc-dmRaPn jYjlfm']")
    public WebElement headphonequan;


    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/button[1]")
    public WebElement checkoutbtn;

    @FindBy(xpath="//input[@id='firstName']")
    public WebElement firstnameinput;

    @FindBy(xpath="//input[@id='address1']")
    public WebElement addressinput;

    @FindBy(xpath="//input[@id='city']")
    public WebElement cityInput;
}
