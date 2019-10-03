package com.teechip; /**
 *   File Name: BasePage.java<br>
 *
 *   Tony<br>
 *   Created: Oct 1, 2019
 *
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author      Tony
 * @version     1.0.0
 * @since       1.0
 *
 */
public class BasePage {

    protected WebElement we;
    protected WebElement we2;

    protected WebDriver driver;
//    protected WebDriverWait wait;
    //

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


}
