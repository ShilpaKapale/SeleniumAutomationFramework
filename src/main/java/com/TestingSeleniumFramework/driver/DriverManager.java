package com.TestingSeleniumFramework.driver;

import com.TestingSeleniumFramework.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class DriverManager {
//this class is responsible for managing webdriver instance across different browser
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }
//Start of browser
    public static void init(){
        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();
        if(driver==null){
            switch(browser){
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--guest");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox" :
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--guest");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    System.out.println("Browser not found!");
            }
        }
    }
    //Close the browser
    public static void down(){

        if (driver!=null){
            driver.quit();
            driver=null;//It should not be null
        }

    }
}
