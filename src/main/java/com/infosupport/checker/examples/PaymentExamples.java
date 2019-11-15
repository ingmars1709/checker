package com.infosupport.checker.examples;

import java.util.Arrays;
import static java.util.Arrays.stream;

public class PaymentExamples {

    public static void main(String[] args) {
        new PaymentExamples().run();
    }

    private void run() {
        Payment payment = Payment.create();
//        payment.partlyApprove();
        payment.approve();

    }
}