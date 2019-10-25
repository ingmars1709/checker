package com.infosupport.checker.examples.states;

import checkers.typestate.NoChange;
import checkers.typestate.State;

import java.lang.annotation.*;

public class PaymentStates {
    private PaymentStates() { }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    public @State @interface Valid {
        Class<? extends Annotation> after() default NoChange.class;
        Class<? extends Annotation> onException() default NoChange.class;
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    public @State @interface PartlyApproved {
        Class<? extends Annotation> after() default NoChange.class;
        Class<? extends Annotation> onException() default NoChange.class;
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    public @State @interface Approved {
        Class<? extends Annotation> after() default NoChange.class;
        Class<? extends Annotation> onException() default NoChange.class;
    }
}