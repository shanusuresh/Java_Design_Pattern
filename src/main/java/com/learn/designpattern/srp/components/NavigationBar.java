package com.learn.designpattern.srp.components;

import com.learn.designpattern.srp.components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb")
    private WebElement navBar;

    @FindBy(linkText = "News")
    private WebElement newsLink;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(linkText = "Images")
    private WebElement imagesLink;


    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void clickNews(){
        this.newsLink.click();
    }

    public void clickVideos(){
        this.videosLink.click();
    }

    public void clickImages(){
        this.imagesLink.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d)->this.navBar.isDisplayed());
    }
}
