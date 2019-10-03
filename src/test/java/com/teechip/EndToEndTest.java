package com.teechip;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest{

    @Test(description="end-to-end test: choose Classic T-shirt -> choose J Navy Color -> choose Size Large -> " +
            "choose Qty One -> Proceed To Checkout -> fill Out Shipping Address -> choose PayPal -> Validation Address",
            enabled=true,
            groups={"all", "regression"},
            priority=0)
    public void testChooseQtyOne() {

        homePage.navigateToHomePage();

        Assert.assertEquals(homePage.chooseClassicTshirt(), "Classic T-Shirt", "Mismatch in chosen Classic T-Shirt");

        Assert.assertEquals(homePage.chooseJnavyColor(), "J Navy", "Mismatch in chosen color");

        Assert.assertEquals(homePage.chooseSizeXL(), "XL", "Mismatch in chosen size");

        Assert.assertEquals(homePage.chooseQtyOne(), "1", "Mismatch in chosen qty");

        homePage.clickBtnBuyItNow();

        cartPage.clickBtnProceedToCheckout();

        String emailTextBox = "jonsmith@gmail.com";
        String fullNameTextBox = "John Smith";
        String addressTextBox = "El Camino, 200";
        String aptSuiteTextBox = "100";
        String cityTextBox = "Redwood City";
        String zipTextBox = "94061";

        checkoutPage.fillOutShippingAddress(emailTextBox, fullNameTextBox, addressTextBox, aptSuiteTextBox
                , cityTextBox, zipTextBox);

        Assert.assertEquals(checkoutPage.choosePayPal(), "Continue With PayPal", "Mismatch in inscription button");

        String expectedValidationAddressText =
                "We had trouble verifying the address you entered. Please make sure it’s correct.";
        Assert.assertEquals(checkoutPage.clickBtnContinueWithPayPal(), expectedValidationAddressText,
                "Mismatch in validation address text");
    }

}
