package com.infosupport.checker.examples;

import com.infosupport.checker.examples.states.PaymentStates;

public class Payment {

    private Payment() {
        // validate args
    }

//    public void approve(@PaymentStates.PartlyApproved(after = PaymentStates.Approved.class) Payment this) {
//
//    }
//
//    public void partlyApprove(@PaymentStates.Valid(after = PaymentStates.PartlyApproved.class) Payment this) {
//
//    }
//
//    public void send(@PaymentStates.Approved Payment this) {
//
//    }
//
//    public static @PaymentStates.Valid Payment create() {
//        return new Payment();
//    }
}