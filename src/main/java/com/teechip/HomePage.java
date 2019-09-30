package com.teechip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebElement we;
    public WebDriverWait wait = new WebDriverWait(driver, 10);

    HomePage(WebDriver driver){
        this.driver=driver;
    }

    HomePage homePage = new HomePage(driver);

    private static String homePageUrl = "https://teechip.com/defaulttest";
    private By classicTshirtBtn = By.cssSelector("div:nth-child(8) > div > div > div > div > img");


    public HomePage navigateToHomePage(){
        driver.navigate().to(homePageUrl);
        return new HomePage(driver);
    }

    public String chooseClassicTshirt(){
        we = wait.until(ExpectedConditions.elementToBeClickable(classicTshirtBtn));
       // we = driver.findElement(By.cssSelector("div:nth-child(8) > div > div > div > div > img"));
        we.click();
        return driver.getCurrentUrl();
    }


}
