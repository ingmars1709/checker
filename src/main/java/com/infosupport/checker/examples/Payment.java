package com.infosupport.checker.examples;

import com.infosupport.checker.qual.ApprovedPayment;
import com.infosupport.checker.qual.ValidPayment;

public class Payment {

    private final Integer amount;
    private boolean canBeProcessed;

    private Payment(final boolean canBeProcessed, final Integer amount) {
        this.canBeProcessed = canBeProcessed;
        this.amount = amount;
    }

    public void send(@ApprovedPayment Payment this) {
        System.out.println("Sending payment with amount: " + this.amount);
    }

    public void printStatus(@ValidPayment Payment this) {
        System.out.println("Can this payment be processed: "+ this.canBeProcessed);
    }

    public @ApprovedPayment Payment approve(@ValidPayment Payment this) {
        return new Payment(true, this.amount);
    }

    public static @ValidPayment Payment createPayment(final Integer amount) {
        return new Payment(true, amount);
    }
}
