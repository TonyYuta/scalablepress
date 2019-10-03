package com.teechip; /**
 *   File Name: HomePage.java<br>
 *
 *   Tony<br>
 *   Created: Oct 1, 2019
 *
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * HomePage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author      Yutaka
 * @version     1.0.0
 * @since       1.0
 *
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait  wait = new WebDriverWait(driver, 10);

    private static String homePageUrl = "https://teechip.com/defaulttest/";

    private By classicTshirtBtn = By.cssSelector("div:nth-child(8) > div > div > div > div > img");
    private By colorNavyBtn = By.cssSelector("div.d-n.lg\\:d-b.mt-1p5 > div.mt-1 > div > div:nth-child(7) > div > div > div");
    private By colorNavyTxt = By.cssSelector("div.d-n.lg\\:d-b.mt-1p5 > div:nth-child(1) > span:nth-child(2)");
    private By sizeXLBtn = By.cssSelector("#product_details_size_container > div.mt-1 > div > div:nth-child(4) > div");
    private By qtyOneDropdown = By.cssSelector("div.flex-grow.truncate.fw-bold.ta-right");
    private By productValue = By.cssSelector(" div.ProductSelector.mt-1p5 > div.d-n.lg\\:d-b > div:nth-child(1) > span:nth-child(2)");
    private By colorValue = By.cssSelector("div.d-n.lg\\:d-b.mt-1p5 > div > span:nth-child(2)");
    private By sizeValue = By.cssSelector(" div.flex-grow.maxw-full > span:nth-child(2)");


    private By byItNowBtn = By.cssSelector("div.mt-1>button");

    public HomePage navigateToHomePage() {

        driver.navigate().to(homePageUrl);
        return new HomePage(driver);
    }

    public String chooseClassicTshirt() {
        int productNumMax = 9;
        String productCssPart1 = "div.mt-1 > div > div:nth-child(";
        String productCssPart2 = ") > div > div > div > div > img";

        for(int i=1; i<productNumMax; i++) {
            By productBtn = By.cssSelector(productCssPart1 + i + productCssPart2);

            we = wait.until(ExpectedConditions.elementToBeClickable(productBtn));
            we.click();

            we2 = wait.until(ExpectedConditions.presenceOfElementLocated(productValue));
            if(we2.getText().equalsIgnoreCase("Classic T-shirt"))
                break;
        }

        we = wait.until(ExpectedConditions.elementToBeClickable(classicTshirtBtn));
        we.click();

        return we2.getText();
    }

    public String chooseJnavyColor() {
        int colorNumMax = 18;
        String colorCssPart1 = "div.d-n.lg\\:d-b.mt-1p5 > div.mt-1 > div > div:nth-child(";
        String colorCssPart2 = ") > div > div > div";
        for(int i=1; i<=colorNumMax; i++) {
            By colorBtn = By.cssSelector(colorCssPart1 + i + colorCssPart2);

            we = wait.until(ExpectedConditions.elementToBeClickable(colorBtn));
            we.click();

            we2 = wait.until(ExpectedConditions.presenceOfElementLocated(colorValue));
            if(we2.getText().equalsIgnoreCase("J Navy"))
                break;
        }

        return we2.getText();
    }

    public String chooseSizeXL() {
        we = wait.until(ExpectedConditions.elementToBeClickable(sizeXLBtn));
        we.click();

        we = wait.until(ExpectedConditions.elementToBeClickable(sizeValue));
        return we.getText();
    }

    public String chooseQtyOne() {
        we = wait.until(ExpectedConditions.elementToBeClickable(qtyOneDropdown));
        we.click();

        we = wait.until(ExpectedConditions.elementToBeClickable(qtyOneDropdown));
        return we.getText();
    }

    public CartPage clickBtnBuyItNow() {
        we = wait.until(ExpectedConditions.elementToBeClickable(byItNowBtn));
        we.click();
        return new CartPage(driver);
    }


}
