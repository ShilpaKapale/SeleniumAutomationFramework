package com.TestingSeleniumFramework.tests.Sample.vwoTestCase;
import com.TestingSeleniumFramework.pages.pageObjectModel.VMO.DashboardPage;
import com.TestingSeleniumFramework.pages.pageObjectModel.VMO.LoginPage;
import com.TestingSeleniumFramework.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_VWOLogin_POM_PropertyReader_04 {

    @Owner("Shilpa")
    @Description("Verify the invalid creds error message")
    @Test
    public void testLoginNegativeVWO() {
        WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
       String error_msg = loginPage_VWO.loginToVMOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
       assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
       Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Owner("Shilpa")
    @Description("Verify the valid creds  message")
    @Test
    public void testLoginPostiveVWO() {
        WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVMOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(driver);
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));

    }
}