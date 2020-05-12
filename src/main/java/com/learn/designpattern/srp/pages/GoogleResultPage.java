package com.learn.designpattern.srp.pages;

import com.learn.designpattern.srp.components.NavigationBar;
import com.learn.designpattern.srp.components.ResulStat;
import com.learn.designpattern.srp.components.SearchSuggestion;
import com.learn.designpattern.srp.components.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {

    private WebDriver driver;
    private SearchSuggestion searchSuggestion;
    private SearchWidget searchWidget;
    private NavigationBar navigationBar;
    private ResulStat resulStat;

    public GoogleResultPage(final WebDriver driver) {
        this.driver = driver;
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resulStat = PageFactory.initElements(driver, ResulStat.class);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResulStat getResulStat() {
        return resulStat;
    }
}
