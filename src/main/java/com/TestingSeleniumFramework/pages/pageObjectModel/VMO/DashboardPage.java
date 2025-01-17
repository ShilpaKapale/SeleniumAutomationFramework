package com.TestingSeleniumFramework.pages.pageObjectModel.VMO;

import com.TestingSeleniumFramework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    //Step 1
    private By userNameDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    //Step 2 : Page Actions
    public String loggedInUserName(){
       visibilityOfElement(userNameDashboard);
        return getText(userNameDashboard);
    }
}
