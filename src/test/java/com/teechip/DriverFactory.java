package com.teechip;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    public static WebDriver driver;
    public static DesiredCapabilities capabilities;
  //  public static String driverPath = "/resources/webdrivers/mac/";

    public static WebDriver getDriver(){
        return driver;
    }

    protected static void setDriver(String browser, String appURL, String groups) {
        switch (browser) {
            case "chrome":

            System.setProperty("webdriver.chrome.driver", "/Library/chromedriver");
            driver = new ChromeDriver();
            driver.get("appURL");
                break;

        case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+
                        "/resources/webdrivers/mac/geckodriver");
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
//		    driver.manage().window().maximize();
                driver.manage().window().setSize(new Dimension(1920, 1080));
                driver.get(appURL);
                break;
            default:
                System.out.println("browser : " + browser
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(appURL);
        }
    }

/*    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", driverPath
                + "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }*/

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }


}
