package com.learn.designpattern.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        this.searchBox.clear();
//        this.searchBox.sendKeys(text);
        for (char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
    }

    @Override
    public boolean isDisplayed() {
//        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
//        return this.searchBox.isDisplayed();
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}
