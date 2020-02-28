package com.infosupport.checker.examples;

import com.infosupport.checker.qual.ApprovedPayment;
import com.infosupport.checker.qual.ValidPayment;

public class Payment {

    private final Integer amount;
    private boolean canBeProcessed;

    private Payment(final Integer amount) {
        this.amount = amount;
    }

    public static @ValidPayment Payment createPayment(final Integer amount) {
        return new Payment(amount);
    }


    public void printStatus(Payment this) {
        System.out.println("Can this payment be processed: "+ this.canBeProcessed);
    }


    @SuppressWarnings("approvedpayment")
    public @ApprovedPayment Payment approve() {
        this.canBeProcessed = true;
        return this;
    }


    public void send(@ApprovedPayment Payment this) {
        System.out.println("Sending payment with amount: " + this.amount);
    }
}