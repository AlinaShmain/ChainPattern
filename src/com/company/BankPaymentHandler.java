package com.company;

public class BankPaymentHandler implements PaymentHandler {

    private PaymentHandler paymentHandler;

    private Account bankAccount;

    public BankPaymentHandler (Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void setNextChain(PaymentHandler nextChain) {
        this.paymentHandler = nextChain;
    }

    @Override
    public void pay(float amountToPay) {
        if(this.bankAccount.getAmount() >= amountToPay){
            System.out.println("Оплачено " + amountToPay + " с использованием банковского счета");
        } else
            if(paymentHandler != null){
            System.out.println("Нельзя оплатить с использованием банковского счета. В процессе ..");
            this.paymentHandler.pay(amountToPay);
        } else {
            System.out.println("Ни на одном из аккаунтов нет необходимых средств");
        }
    }
}
