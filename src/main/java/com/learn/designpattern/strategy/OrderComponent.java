package com.learn.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponent {

    @FindBy(id="buy")
    private WebElement buyBtn;

    @FindBy(id="ordernumber")
    private WebElement orderNum;

    public OrderComponent(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String placeOrder(){
        this.buyBtn.click();
        return this.orderNum.getText();
    }
}
