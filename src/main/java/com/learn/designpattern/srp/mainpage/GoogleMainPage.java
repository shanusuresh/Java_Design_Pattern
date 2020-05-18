package com.learn.designpattern.srp.mainpage;

import com.learn.designpattern.srp.common.SearchSuggestion;
import com.learn.designpattern.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchSuggestion searchSuggestion;
    private SearchWidget searchWidget;

    public GoogleMainPage(final WebDriver driver){
        this.driver = driver;
        this.searchSuggestion = PageFactory.initElements(driver,SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(driver,SearchWidget.class);
    }

    public void goToUrl(){
        this.driver.get("https://www.google.com");
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }
}
