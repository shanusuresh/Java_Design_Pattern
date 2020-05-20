package com.learn.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.debugger.Page;

public abstract class GooglePage {

    public abstract void launchSite();
    public abstract void search(String keyword);
    public abstract int getResultsCount();
}
