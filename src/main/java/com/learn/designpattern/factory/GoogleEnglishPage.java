package com.learn.designpattern.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Implementation class for English language
 */
 class GoogleEnglishPage extends GooglePage {

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
        this.wait.until((d)->this.searchBox.isDisplayed());
        this.searchBox.clear();
        System.out.println("Cleared search box");
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        System.out.println("Entered keyword");
        this.wait.until((d)->this.searchButton.isDisplayed());
        this.searchButton.click();
        System.out.println("Clicked");
    }


    @Override
    public int getResultsCount() {
        this.wait.until((d)->this.searchResults.size()>1);
        return this.searchResults.size();
    }
}
