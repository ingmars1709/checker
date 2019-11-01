package com.infosupport.checker.examples;

import java.util.Arrays;
import static java.util.Arrays.stream;

public class PaymentExamples {

    public static void main(String[] args) {
        new PaymentExamples().run();
    }

    private void run() {

//        stream(Payment.class.getDeclaredMethods()).forEach(
//                m -> {
//                    if (m.getAnnotatedReceiverType() != null) {
//                    System.out.println(Arrays.toString(m.getAnnotatedReceiverType().getAnnotations()));
//                    }});
//
//        Payment payment = Payment.create();
//
//        payment.partlyApprove();
//        payment.approve();
//        payment.send();
    }
}