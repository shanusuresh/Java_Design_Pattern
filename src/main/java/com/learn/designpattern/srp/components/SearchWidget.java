package com.learn.designpattern.srp.components;

import com.learn.designpattern.srp.components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        this.searchBox.clear();
        this.searchBox.sendKeys(text);
    }

    @Override
    public boolean isDisplayed() {
//        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
//        return this.searchBox.isDisplayed();
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}
