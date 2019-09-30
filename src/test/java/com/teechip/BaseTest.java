package com.teechip;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    HomePage homePage;

    @Parameters({"browser","appUrl","groups"})
    @BeforeClass(alwaysRun=true)
    public void initializeTestBaseSetup(String browser, String appUrl, String groups){

    }
}
