package com.learn.designpattern.tests.factory;

import com.learn.designpattern.factory.GoogleFactory;
import com.learn.designpattern.factory.GooglePage;
import com.learn.designpattern.tests.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTests {
    private GooglePage googlePage;

    /**
     *
     * @param language
     * @param keyword
     * GoogleFactory class is called to get the right implementation for the language passed
     */
    @Test(dataProvider = "getData")
    public void searchTest(String language,String keyword){
        this.googlePage = GoogleFactory.get(language,this.driver); //This abstracts the implementation logic from the user
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultsCount();
        System.out.println("Result Count: "+resultCount);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"ENG","Selenium"},
                {"TAM","Selenium"},
                {"HIN","Selenium"},
                {"MAL","Selenium"}
        };
    }

}
