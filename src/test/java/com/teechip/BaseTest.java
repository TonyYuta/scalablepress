package com.teechip;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;

    HomePage homePage;

    /**
     * @param browser
     * @param appURL
     */
    @Parameters({ "browser", "appURL", "groups" })
    @BeforeClass(alwaysRun = true)
    public void initializeTestBaseSetup(String browser, String appURL, String groups) {
        try {
            DriverFactory.setDriver(browser, appURL, groups);
        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
        driver = DriverFactory.getDriver();

        homePage = new HomePage(driver);
    }

    @AfterClass(enabled = true, alwaysRun = true)
    public void afterClassTearDown() {
        //driver.close();
        driver.quit();
    }
}
