package com.infosupport.checker.examples;

import com.infosupport.checker.qual.ApprovedPayment;
import com.infosupport.checker.qual.ValidPayment;

public class PaymentExamples {

    public static void main(String[] args) {
        new PaymentExamples().run();
    }

    private void run() {
        @ValidPayment Payment payment = Payment.createPayment(10);

        payment.printStatus();

        payment.send();

        payment.approve().send();

        final @ApprovedPayment Payment approvedPayment = payment.approve();
        approvedPayment.printStatus();
        approvedPayment.send();
    }
}
