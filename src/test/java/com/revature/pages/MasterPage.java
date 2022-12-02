package com.revature.pages;

import com.revature.runner.MainRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MasterPage {
    public MasterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // GET URL
    public void getURL(String pageURL) {
        MainRunner.driver.get(pageURL);
    }

    // GET ALERT
    public String getAlert() {
        return MainRunner.driver.switchTo().alert().getText();
    }
}