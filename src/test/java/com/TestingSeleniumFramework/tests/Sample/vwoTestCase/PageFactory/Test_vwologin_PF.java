package com.TestingSeleniumFramework.tests.Sample.vwoTestCase.PageFactory;

import com.TestingSeleniumFramework.base.BaseTest;
import com.TestingSeleniumFramework.driver.DriverManager;
import com.TestingSeleniumFramework.pages.pageFactory.LoginPage_PF;
import com.TestingSeleniumFramework.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_vwologin_PF extends BaseTest {

    private static final Logger logger = LogManager.getLogger(Test_vwologin_PF.class);
    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));
        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }

}
