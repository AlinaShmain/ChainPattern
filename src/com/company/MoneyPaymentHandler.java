package com.company;

public class MoneyPaymentHandler implements PaymentHandler {

    private PaymentHandler paymentHandler;

    private Account paypalAccount;

    public MoneyPaymentHandler(Account account) {
        this.paypalAccount = account;
    }

    @Override
    public void setNextChain(PaymentHandler nextChain) {
        this.paymentHandler = nextChain;
    }

    @Override
    public void pay(float amountToPay) {
        if(this.paypalAccount.getAmount() >= amountToPay){
            System.out.println("Оплачено " + amountToPay + " с использованием системы денежных переводов");
        } else
        if(paymentHandler != null){
            System.out.println("Нельзя оплатить с использованием денежных переводов. В процессе ..");
            this.paymentHandler.pay(amountToPay);
        } else {
            System.out.println("Ни на одном из аккаунтов нет необходимых средств");
        }
    }
}
