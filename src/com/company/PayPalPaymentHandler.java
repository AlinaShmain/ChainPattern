package com.company;

public class PayPalPaymentHandler implements PaymentHandler {

    private PaymentHandler paymentHandler;

    private Account paypalAccount;

    public PayPalPaymentHandler(Account account) {
        this.paypalAccount = account;
    }

    @Override
    public void setNextChain(PaymentHandler nextChain) {
        this.paymentHandler = nextChain;
    }

    @Override
    public void pay(float amountToPay) {
        if(this.paypalAccount.getAmount() >= amountToPay){
            System.out.println("Оплачено " + amountToPay + " с использованием системы Paypal");
        } else
        if(paymentHandler != null){
            System.out.println("Нельзя оплатить с использованием Paypal. В процессе ..");
            this.paymentHandler.pay(amountToPay);
        } else {
            System.out.println("Ни на одном из аккаунтов нет необходимых средств");
        }
    }
}
