package com.teechip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private By shippingAddressText = By.cssSelector("div:nth-child(1) > div > h2 > span");
    private By emailTextBox = By.cssSelector("div.py-p5>div>input:first-child");
    private By fullNameTextBox = By.cssSelector(" div:nth-child(1) > div > div > div > div > div > div > input");
    private By addressTextBox = By.xpath("//input[@name='address-line1']");
    private By aptSuiteTextBox = By.xpath("//input[@name='address-line2']");
    private By cityTextBox = By.cssSelector("div:nth-child(3) > div > div > div > div > div > input");
    private By zipTextBox = By.cssSelector("div:nth-child(4) > div.px-p5.w-1\\/3 > div > div > div > div > div > input");
    private By paymentInfoText = By.cssSelector(" div.flex-none > h2 > span");
    private By payPalRadioBtn = By.cssSelector(" div.p-1.bwt-1.bc-grey-400 > div > div.flex-none > i");
    private By continueWithPayPalBtn = By.cssSelector("div:nth-child(1) > div > div:nth-child(12)");
    private By cardNumberTextBox = By.id("credit-card-number");
    private By expirationTextBox = By.xpath("//*[@id=\"expiration\"]");
    private By cvvTextBox = By.xpath("//*[@id=\"cvv\"]");
    private By placeYourOrderBtn = By.cssSelector("div:nth-child(12) > button");
    private By addressValidationText = By.cssSelector("div:nth-child(4) > span");

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public String fillOutShippingAddress(String email, String fullName, String address, String aptSuite
            , String city, String zip) {

        we = wait.until(ExpectedConditions.presenceOfElementLocated(emailTextBox));
        we.clear();
        we.sendKeys(email);

        we = wait.until(ExpectedConditions.presenceOfElementLocated(fullNameTextBox));
        we.clear();
        we.sendKeys(fullName);

        we = wait.until(ExpectedConditions.presenceOfElementLocated(addressTextBox));
        we.clear();
        we.sendKeys(address);

        we = wait.until(ExpectedConditions.presenceOfElementLocated(aptSuiteTextBox));
        we.clear();
        we.sendKeys(aptSuite);

        we = wait.until(ExpectedConditions.presenceOfElementLocated(cityTextBox));
        we.clear();
        we.sendKeys(city);

        we = wait.until(ExpectedConditions.presenceOfElementLocated(zipTextBox));
        we.clear();
        we.sendKeys(zip);

        we = wait.until(ExpectedConditions.presenceOfElementLocated(shippingAddressText));
        return we.getText();
    }

    public String choosePayPal() {
        we = wait.until(ExpectedConditions.presenceOfElementLocated(payPalRadioBtn));
        we.click();

        we = wait.until(ExpectedConditions.presenceOfElementLocated(continueWithPayPalBtn));
        return we.getText();
    }

    public String clickBtnContinueWithPayPal() {
        we = wait.until(ExpectedConditions.presenceOfElementLocated(continueWithPayPalBtn));
        we.click();

        we = wait.until(ExpectedConditions.presenceOfElementLocated(addressValidationText));
        return we.getText();
    }

}
