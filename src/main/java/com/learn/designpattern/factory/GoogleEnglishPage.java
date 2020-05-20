package com.learn.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleEnglishPage extends GooglePage {

    @FindBy(name = "q")
    protected WebElement searchBox;

    @FindBy(name="btnK")
    protected WebElement searchButton;

    @FindBy(css = "div.rc")
    protected List<WebElement> searchResults;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public GoogleEnglishPage(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver,30);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        this.searchBox.clear();
        this.searchBox.sendKeys(keyword);
        this.wait.until((d)->this.searchButton.isDisplayed());
        this.searchBox.click();
    }

    @Override
    public int getResultsCount() {
        this.wait.until((d)->this.searchResults.size()>1);
        return this.searchResults.size();
    }
}
