package com.TestingSeleniumFramework.pages.pageFactory;

import com.TestingSeleniumFramework.base.BasePage;
import com.TestingSeleniumFramework.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends BasePage {
//**Page Factory**
//            - Page Factory is an inbuilt POM concept in Selenium WebDriver that optimizes the implementation of POM.
//            - Use of @FindBy, .@FaindAll annotation to locate web element
//- Automatic initialization of web elements using the initElements() method.
//            - Provides initialization of elements.(at start)
//            ## Key Differences
//**Element Location**
//            - POM: Uses 'By' locator to find elements
//- Page Factory: Uses @FindBy annotation

//**Initialization**
//            - POM: Requires manual initialization of each page object.
//- Page Factory: Uses initElements() method for automatic initializatiom

//**Efficiency**
//
//            - POM: May be less efficient due to manual element location
//- Page Factory: More efficient due to initialization

//    Page Factory offers a structured approach with annotations ->
//    Can lead to **StaleElementException** if the HTML Page / DOM changes/refreshed.
//    SPA -> where lot of changes in DOM/ HTML Pages( Refresh frequently_ try to avoid the Page Factory. - G


            public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="login-username")
    private WebElement username;

    @FindBy(id="login-password")
    private WebElement password;

    @FindBy(id="js-login-btn")
    private WebElement signButton;

    @FindBy(css="#js-notification-box-msg")
    private WebElement error_message;

    // Page Actions
    public String loginToVWOInvalidCreds() {
        enterInput(username, PropertiesReader.readKey("invalid_username"));
        enterInput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(signButton);
        custom_wait();
        return getText(error_message);

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
