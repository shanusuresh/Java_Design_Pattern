package com.learn.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Implementation class for Tamil language
 * Extends GoogleEnglish to reuse the Webelements and implementation
 */
 class GoogleHindiPage extends GoogleEnglishPage {

    @FindBy(linkText = "हिन्दी")
    private WebElement langLink;

    @FindBy(css = "span.hOoLGe")
    private WebElement keyboardBtn;

    @FindBy(id="kbd")
    private WebElement keyboard;

    public GoogleHindiPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://google.com");
        this.wait.until((d)-> this.langLink.isDisplayed());
        this.langLink.click();
    }

    public void search(String keyword){
        this.wait.until((d)-> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((d)-> this.keyboard.isDisplayed());
        this.keyboard.click();
        super.search(keyword);
    }

}
