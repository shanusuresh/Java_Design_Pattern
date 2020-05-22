package com.learn.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMalayalamPage extends GoogleEnglishPage {

    @FindBy(linkText = "മലയാളം")
    private WebElement langLink;

    @FindBy(css = "span.hOoLGe")
    private WebElement keyboardBtn;

    @FindBy(id="kbd")
    private WebElement keyboard;

    public GoogleMalayalamPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
        this.wait.until((d)-> this.langLink.isDisplayed());
        this.langLink.click();
    }

    @Override
    public void search(String keyword) {
        this.wait.until((d)->this.keyboardBtn.isDisplayed());
        System.out.println("Clicked keyboard button");
        this.keyboardBtn.click();
        this.wait.until((d)->this.keyboard.isDisplayed());
        System.out.println("Clicked keyboard");
        this.keyboard.click();
        this.keyboardBtn.click();
        this.wait.until((d)->this.searchBox.isDisplayed());
        this.searchBox.clear();
        this.searchBox.sendKeys(keyword);
        this.wait.until((d)->this.searchButton.isDisplayed());
        this.searchButton.click();
    }
}
