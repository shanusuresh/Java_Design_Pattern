package com.learn.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class CreditCardOption implements PaymentOption {
    @FindBy(id="cc")
    private WebElement ccNum;

    @FindBy(id="year")
    private WebElement year;

    @FindBy(id="cvv")
    private WebElement cvv;

    public CreditCardOption(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @Override
    public void enterPaymentDetails(Map<String, String> paymentDetails) {
        this.ccNum.sendKeys(paymentDetails.get("ccNum"));
        this.year.sendKeys(paymentDetails.get("year"));
        this.cvv.sendKeys(paymentDetails.get("cvv"));
    }
}
