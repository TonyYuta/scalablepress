package com.teechip;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test(description="test Choose Classic T-Shirt",
    enabled=true,
    groups={"all", "bat", "regression"},
    priority=1)
    public void testChooseClassicTshirt(){
        String expected = "Classic T-Shirts - Homepage";
        homePage.navigateToHomePage();
        Assert.assertEquals(homePage.chooseClassicTshirt(), expected, "URI doesn't match to Home page");
    }
}
