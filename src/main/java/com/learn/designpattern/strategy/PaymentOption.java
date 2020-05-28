package com.learn.designpattern.strategy;

import java.util.Map;

public interface PaymentOption {

    public void enterPaymentDetails(Map<String,String> paymentDetails);
}
