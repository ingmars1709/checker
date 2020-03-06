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


        ////////////// EXAMPLE 3 ////////////// limitation of subtyping checker
        payment.approve();
        payment.send();


        ////////////// EXAMPLE 4 //////////////
        payment = payment.approve(); // transferring the state
        payment.printStatus();
        payment.send();


        ////////////// EXAMPLE 5 //////////////
        payment = payment.approve();
        payment.printStatus();
        payment = payment.reject();
        payment.send();
        payment.reject();
        payment = payment.approve();
        payment.send();
    }
}