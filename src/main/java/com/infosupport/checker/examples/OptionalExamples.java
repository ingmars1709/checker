package com.infosupport.checker.examples;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {

        ////////////// EXAMPLE 1 //////////////


        Optional<Integer> optionalIntegerWhichIsEmpty = Optional.empty();
        optionalIntegerWhichIsEmpty.get();


        ////////////// EXAMPLE 2 //////////////


        Optional<Integer> optionalIntegerWhichIsNotEmpty = Optional.of(4);
        optionalIntegerWhichIsNotEmpty.get();


        ////////////// EXAMPLE 3 //////////////


        // Safe use enforced by compiler
        Optional<Integer> safeUseOfOptional = Optional.empty();
        if (safeUseOfOptional.isPresent()) {
            safeUseOfOptional.get();
        }
    }
}