package com.learn.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformationComponent {

    @FindBy(id="fn")
    private WebElement firstName;

    @FindBy(id="ln")
    private WebElement lastName;

    @FindBy(id="email")
    private WebElement email;

    public UserInformationComponent(final WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void enterDetails(String fn, String ln, String email){
        this.firstName.sendKeys(fn);
        this.lastName.sendKeys(ln);
        this.email.sendKeys(email);
    }



}
