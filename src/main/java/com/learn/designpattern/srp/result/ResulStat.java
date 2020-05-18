package com.learn.designpattern.srp.result;

import com.learn.designpattern.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResulStat extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement stats;

    public ResulStat(WebDriver driver) {
        super(driver);
    }

    public String getStat() {
        return this.stats.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.stats.isDisplayed());
    }
}
