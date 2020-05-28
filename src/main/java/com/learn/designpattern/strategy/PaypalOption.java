package com.learn.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaypalOption implements PaymentOption{

    @FindBy(id="paypal_username")
    private WebElement paypalUsername;

    @FindBy(id="paypal_password")
    private WebElement paypalPassword;

    public PaypalOption(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @Override
    public void enterPaymentDetails(Map<String, String> paymentDetails) {
        this.paypalUsername.sendKeys(paymentDetails.get("paypalUsername"));
        this.paypalPassword.sendKeys(paymentDetails.get("paypalPassword"));
    }
}
