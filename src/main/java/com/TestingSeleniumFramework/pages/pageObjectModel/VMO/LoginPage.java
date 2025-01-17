package com.TestingSeleniumFramework.pages.pageObjectModel.VMO;

import com.TestingSeleniumFramework.base.BasePage;
import com.TestingSeleniumFramework.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    //Step 1
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    //Step 2
    public String loginToVMOLoginInvalidCreds(String user,String pwd) {
        openURL();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        //presenceOfElement(error_message);
        custom_wait();
        String error_message_text = getText(error_message);
        return error_message_text;

    }

    public void loginToVMOLoginValidCreds(String user,String pwd)
    {
        openURL();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        custom_wait();

    }
}
