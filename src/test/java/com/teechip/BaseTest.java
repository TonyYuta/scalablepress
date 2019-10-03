package com.teechip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;


    /**
     * @param browser
     * @param appURL
     * @param groups
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
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        wait = new  WebDriverWait(driver, 10);
    }

    @AfterClass(enabled = true, alwaysRun = true)
    public void afterClassTearDown() {
        //driver.close();
        driver.quit();
    }
}
