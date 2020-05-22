package com.learn.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
/**
 * Implementation class for Tamil language
 * Extends GoogleEnglish to reuse the Webelements and implementation
 */
 class GoogleTamilPage extends GoogleEnglishPage {

    @FindBy(linkText = "தமிழ்")
    private WebElement langLink;

//    @FindBy(name = "q")
//    private WebElement searchBox;
//
//    @FindBy(name="btnK")
//    private WebElement searchButton;
//
//    @FindBy(css = "div.rc")
//    private List<WebElement> searchResults;

    public GoogleTamilPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
        this.wait.until((d)->this.langLink.isDisplayed());
        this.langLink.click();
    }

}
