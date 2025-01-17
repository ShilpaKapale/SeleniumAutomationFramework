package com.TestingSeleniumFramework.tests.Sample.vwoTestCase;
import com.TestingSeleniumFramework.base.BaseTest;
import com.TestingSeleniumFramework.driver.DriverManager;
import com.TestingSeleniumFramework.pages.pageObjectModel.VMO.DashboardPage;
import com.TestingSeleniumFramework.pages.pageObjectModel.VMO.LoginPage;
import com.TestingSeleniumFramework.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Test_VWOLogin_ImprovedPOM_PropertyReader_DriverManger_log_06 extends BaseTest {

    private static final Logger logger = LogManager.getLogger(Test_VWOLogin_ImprovedPOM_PropertyReader_DriverManger_log_06.class);

    @Owner("Shilpa")
    @Description("Verify the invalid creds error message")
    @Test
    public void testLoginNegativeVWO() {

        logger.info("Starting the testcase Page object model");
        //WebDriver driver = new EdgeDriver(); //this is not required

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
       String error_msg = loginPage_VWO.loginToVMOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("Ending the testcase Page object model and asserting output");
        //Asserertion AssertJ
       assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
       //Assertion TestNG
       Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Owner("Shilpa")
    @Description("Verify the valid creds  message")
    @Test
    public void testLoginPostiveVWO() {
        logger.info("Starting the testcase Page object model | Verify dashboardpage");
      //  WebDriver driver = new EdgeDriver();
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVMOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        logger.info("Ending the testcase Page object model and asserting output");

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));

    }
}
