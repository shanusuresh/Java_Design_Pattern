package com.learn.designpattern.tests.srp;

import com.learn.designpattern.srp.pages.GoogleMainPage;
import com.learn.designpattern.srp.pages.GoogleResultPage;
import com.learn.designpattern.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTests extends BaseTests {

        private GoogleResultPage googleResultPage;
        private GoogleMainPage googleMainPage;

    @BeforeTest
    public void setupPages(){
        googleResultPage = new GoogleResultPage(driver);
        googleMainPage = new GoogleMainPage(driver);
    }

    @Test
    public void googleTest(){
        googleMainPage.goToUrl();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());
    }
}
