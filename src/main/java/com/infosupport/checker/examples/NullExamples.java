package com.infosupport.checker.examples;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public class NullExamples {

    public static void main(String[] args) {

        ////////////// EXAMPLE 1 //////////////

        Integer @NonNull [] numbers = null;
        @NonNull Object foo = null;

        // @NonNull is default
        Object ref = null;
        ref.toString();

        @Nullable Integer x = null;
        x.toString();
        x.toString();



        ///////////// EXAMPLE 2 ////////////

        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("foo", 1);
        myMap.put("bar", 2);
        myMap.put("baz", null);

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