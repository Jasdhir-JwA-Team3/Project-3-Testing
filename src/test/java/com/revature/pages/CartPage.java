package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Page urls
    public String carturlpage = "http://localhost:3000/cart";
    public String checkouturlpage = "http://localhost:3000/checkout";

    public String profileurlpage = "http://localhost:3000/userProfile";

    //Address information
    public String fname = "Anwar";
    public String lname = "Darkazanli";
    public String address = "777 Orange St.";
    public String State = "New York";
    public String city = "Queens";
    public String zip = " 30024";
    public String country = "US";

    //CreditCardInformation
    public String creditcardnumber = "abc";
    public String cvvnumber ="123";
    public String expdatenumber = "08/29/1992";


    //Buy Icons for items
    @FindBy(xpath="//body/div[@id=" +
            "'root']/div[@class='sc-himrzO " +
            "gFAZYV']/div[1]/div[1]/div[1]/div[1]")
        public WebElement headphonebuyicon;

//    @FindBy(xpath=" ")
//    public WebElement  ;
//



    //Nav Bar Tabs
    @FindBy(xpath="//*[name()='path' and contains(@d,'M15.55 13c')]")
    public WebElement cartnavbartabicon;

    @FindBy(xpath="//strong[contains(text(),'ORDERS')]")
    public WebElement ordersnavbartabicon;

    @FindBy(xpath="//strong[contains(text(),'PROFILE')]")
    public WebElement profilenavbartab;

    @FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/h1[1]/img[1]")
    public WebElement congomainpagetab;



    //Display texts
    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")
    public WebElement headphonenamedisplay;

    @FindBy(xpath="//b[normalize-space()='ID:']")
    public WebElement headphoneidisplay;

    @FindBy(xpath="//div[@class='sc-dmRaPn jYjlfm']")
    public WebElement headphonequantitydisplay;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[4]/span[2]")
    public WebElement totalCostofOrderDisplay;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[1]/span[2]")
    public WebElement subtotalcostoforderdisplay ;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[2]/span[2]")
    public WebElement estimatedshippingcostdisplay ;

    @FindBy(xpath="//h5[contains(text(),'Thank you for your order.')] ")
    public WebElement thankyoufororderconfirmation ;

    @FindBy(xpath="//td[contains(text(),'1111222233334444')]")
    public WebElement originalcardnumberdisplay;




    //Buttons
    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/button[1]")
    public WebElement checkoutnowbtn;

    @FindBy(xpath="//body/div[@id='root']/main[2]/div[1]/form[1]/div[1]/div[4]/div[1]/button[1]")
    public WebElement addpaymentsubmitbutton;

    @FindBy(xpath="//tbody/tr[2]/td[4]/button[1]")
    public WebElement deletepaymentbutton;

    @FindBy(xpath="//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tr[1]/label[1]/span[1]/input[1]")
    public WebElement checkmarkpaymentbutton;

    @FindBy(xpath="//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/button[1]")
    public WebElement submitpaymentbutton;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[2]/*[1]")
    public WebElement trashcanremoveitemquantityicon;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[3]")
    public WebElement quantityincreasebtn;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]")
    public WebElement quantitydecreasebtn;

    @FindBy(xpath="//body/div[@id='root']/main[1]/div[1]/form[1]/div[2]/button[1]")
    public WebElement nextbuttonshippingpage;

    @FindBy(xpath="//body/div[@id='root']/main[1]/div[1]/div[3]/button[2] ")
    public WebElement placeorderbutton;

     @FindBy(xpath="//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/button[3]")
     public WebElement fakeeditpaymentbutton;


    //Fields
    @FindBy(xpath="//input[@id='firstName']")
    public WebElement firstnameinputfield;

    @FindBy(xpath="//input[@id='lastName']")
    public WebElement lastnameinputfield;

    @FindBy(xpath="//input[@id='address1']")
    public WebElement addressinputfield;

    @FindBy(xpath="//input[@id='city']")
    public WebElement cityInputfield;

    @FindBy(xpath="//input[@id='state']")
    public WebElement stateInputfield;

    @FindBy(xpath="//input[@id='country']")
    public WebElement zipInputfield;

    @FindBy(xpath="//input[@id='zip']")
    public WebElement countryInputfield;

    @FindBy(xpath="//input[@id='cardNumber']")
    public WebElement cardnumberinputfield;

    @FindBy(xpath="//input[@id='expDate']")
    public WebElement expdateinputfield;

    @FindBy(xpath="//input[@id='ccv']")
    public WebElement cvvinputfield;


//    @FindBy(xpath=" ")
//    public WebElement  ;

//    @FindBy(xpath=" ")
//    public WebElement  ;

//    @FindBy(xpath="")
//    public WebElement  ;


}
