package com.TestingSeleniumFramework.pages.pageObjectModel.VMO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    //Step 1
    private By userNameDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    //Step 2 : Page Actions
    public String loggedInUserName(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        return driver.findElement(userNameDashboard).getText();
    }
}
