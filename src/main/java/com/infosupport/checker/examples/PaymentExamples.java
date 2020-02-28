package com.infosupport.checker.examples;

public class PaymentExamples {

    public static void main(String[] args) {
        new PaymentExamples().run();
    }

    private void run() {

        ////////////// EXAMPLE 1 //////////////
        Payment payment = Payment.createPayment(10);
        payment.printStatus();
        payment.send();


        ////////////// EXAMPLE 2 //////////////
        payment.approve().send();


        ////////////// EXAMPLE 3 //////////////
        final Payment approvedPayment = payment.approve();
        approvedPayment.printStatus();
        approvedPayment.send();


        ////////////// EXAMPLE 4 ////////////// limitation of subtype checker
        payment.approve();
        payment.send();
    }
}