package com.TestingSeleniumFramework.base;

import com.TestingSeleniumFramework.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }

    @AfterMethod
    public void teardown(){
        DriverManager.down();
    }
}
