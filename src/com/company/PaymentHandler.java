package com.company;

public interface PaymentHandler {
    void setNextChain(PaymentHandler nextChain);
    void pay(float amountToPay);
}
