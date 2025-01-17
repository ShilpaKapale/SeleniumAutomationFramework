package com.TestingSeleniumFramework.tests.Sample.orangeHRTestCase;

import com.TestingSeleniumFramework.pages.pageObjectModel.OrangeHRM.EmployeeListHomePage;
import com.TestingSeleniumFramework.pages.pageObjectModel.OrangeHRM.LoginHRPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestOrangeHR_POM {

    @Owner("Shilpa")
    @Description("Verify that the login to OrangeHR")
    @Test
    public void testLoginPositive() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        LoginHRPage loginHRPage = new LoginHRPage(driver);
        Thread.sleep(3000);
        loginHRPage.loginHRCreds("admin","Hacker@4321");

        EmployeeListHomePage employeeListHomePage = new EmployeeListHomePage(driver);
        String loggedInUserName = employeeListHomePage.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,"PIM");
    }
}
