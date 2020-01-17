package com.infosupport.checker.qual;

import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@SubtypeOf(ValidPayment.class)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface ApprovedPayment {
}
