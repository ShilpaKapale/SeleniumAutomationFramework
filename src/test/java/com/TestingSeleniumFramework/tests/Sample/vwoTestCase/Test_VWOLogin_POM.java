package com.TestingSeleniumFramework.tests.Sample.vwoTestCase;
import com.TestingSeleniumFramework.pages.pageObjectModel.VMO.DashboardPage;
import com.TestingSeleniumFramework.pages.pageObjectModel.VMO.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test_VWOLogin_POM {

    @Owner("Shilpa")
    @Description("Verify the invalid creds error message")
    @Test
    public void testLoginNegativeVWO() {
        WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
       String error_msg = loginPage_VWO.loginToVMOLoginInvalidCreds("admin@gmail.com","123");
       assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
       Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

    }

    @Owner("Shilpa")
    @Description("Verify the valid creds  message")
    @Test
    public void testLoginPostiveVWO() {
        WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVMOLoginValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Aman");

    }
}
