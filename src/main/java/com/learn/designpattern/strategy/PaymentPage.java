package com.learn.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private WebDriver driver;
    private UserInformationComponent userInformationComponent;
    private OrderComponent orderComponent;
    private PaymentOption paymentOption;

    private PaymentPage(final WebDriver driver){
        this.driver=driver;
        this.userInformationComponent=PageFactory.initElements(driver,UserInformationComponent.class);
        this.orderComponent = PageFactory.initElements(driver,OrderComponent.class);

    }

    public OrderComponent getOrderComponent() {
        return orderComponent;
    }

    public UserInformationComponent getUserInformationComponent() {
        return userInformationComponent;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }
}
