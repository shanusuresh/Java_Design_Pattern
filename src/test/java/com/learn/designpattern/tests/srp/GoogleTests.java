package com.learn.designpattern.tests.srp;

import com.learn.designpattern.srp.mainpage.GoogleMainPage;
import com.learn.designpattern.srp.result.GoogleResultPage;
import com.learn.designpattern.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTests extends BaseTests {

        private GoogleResultPage googleResultPage;
        private GoogleMainPage googleMainPage;

    @BeforeTest
    public void setupPages(){
        googleResultPage = new GoogleResultPage(driver);
        googleMainPage = new GoogleMainPage(driver);
    }

    @Test(dataProvider = "getData")
    public void googleTest(String keyword, int index){
//        String keyword ="Jenkins integration";
//        int index = 3;
        googleMainPage.goToUrl();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());
        googleMainPage.getSearchWidget().enterText(keyword);

        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());
        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(3);

        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());
        googleResultPage.getSearchWidget().enterText(keyword);

        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());
        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());
        googleResultPage.getNavigationBar().clickNews();

        Assert.assertTrue(googleResultPage.getResulStat().isDisplayed());
        System.out.println(googleResultPage.getResulStat().getStat());
    }

    @DataProvider
    public Object[][] getData(){
            return new Object[][]{
                    {"Jenkins integration",3},
                    {"Docker",2}
        };
    }
}
