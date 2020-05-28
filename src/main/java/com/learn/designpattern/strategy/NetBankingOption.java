package com.learn.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBankingOption implements PaymentOption{

    @FindBy(id="bank")
    private WebElement bankName;

    @FindBy(id="acc_number")
    private WebElement accNum;

    @FindBy(id="pin")
    private WebElement pin;

    public NetBankingOption(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @Override
    public void enterPaymentDetails(Map<String, String> paymentDetails) {
        Select bankDropdown = new Select(bankName);
        bankDropdown.selectByValue(paymentDetails.get("bank"));
        this.accNum.sendKeys(paymentDetails.get("acc"));
        this.pin.sendKeys(paymentDetails.get("pin"));
    }
}
