package com.company;

public class PaymentChain {

    private PaymentHandler chain;

    public PaymentChain() {

        this.chain = new BankPaymentHandler(new Account(100));

        PaymentHandler paypalHandlerObj = new PayPalPaymentHandler(new Account(200));
        PaymentHandler moneyHandlerObj = new MoneyPaymentHandler(new Account(300));

        chain.setNextChain(paypalHandlerObj);
        paypalHandlerObj.setNextChain(moneyHandlerObj);
    }

    public static void main(String[] args) {
        PaymentChain paymentChainObj = new PaymentChain();

        paymentChainObj.chain.pay(259);
    }
}
