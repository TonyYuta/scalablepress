package com.teechip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private By proceedToCheckoutBtn =
            By.cssSelector("div.w-1\\/2.flex.flex-row-reverse > div > div.p-relative.px-1 > button");

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickBtnProceedToCheckout(){
        we = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
        we.click();
        return new CheckoutPage(driver);
    }

}
