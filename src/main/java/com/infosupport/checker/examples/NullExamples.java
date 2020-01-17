package com.infosupport.checker.examples;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public class NullExamples {

    public static void main(String[] args) {

        ////////////// EXAMPLE 1 //////////////

        @NonNull Object foo = null;

        Object ref = null;
        ref.toString();

        ///////////// EXAMPLE 2 ////////////

        Map<String, @NonNull Integer> myMap = new HashMap<>();
        myMap.put("foo", 1);
        myMap.put("bar", 2);
        myMap.put("baz", null);

        myMap.get("baz").toString();
        myMap.get("foo").toString(); // false positive

        @SuppressWarnings("dereference.of.nullable")
        String result = myMap.get("bar").toString(); // suppressed false positive


        Map<String, @Nullable Integer> myMap2 = new HashMap<>();
        myMap2.put("foo", 1);
        myMap2.put("bar", 2);
        myMap2.put("baz", null);


        ///////////// EXAMPLE 3 ////////////

        @MonotonicNonNull Object lazyInitialized = null;

        lazyInitialized.toString();

        lazyInitialized = new Object();
        lazyInitialized.toString();

        lazyInitialized = null;
        lazyInitialized.toString();


        ///////////// EXAMPLE 4 ////////////

        compare(5,4);
    }

    private static int compare(int x, int y) {
        return x < y ? x : null;
    }
}