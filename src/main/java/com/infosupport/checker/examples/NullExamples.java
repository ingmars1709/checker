package com.infosupport.checker.examples;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public class NullExamples {

    public static void main(String[] args) {

        Integer @NonNull [] numbers = null;
        @NonNull Object foo = null;

        // @NonNull is default
        Object ref = null;
        ref.toString();

        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("foo", 1);
        myMap.put("bar", 2);
        myMap.put("baz", null);

        //

        @Nullable Integer x = null;
        x.toString();
        x.toString();

        //

        @NonNull Object neverNull = new Object();

        if (neverNull == null) {
            System.out.println("??");
        }

        //

        @MonotonicNonNull Object lazyInitialized = null;

        lazyInitialized.toString();

        lazyInitialized = new Object();
        lazyInitialized.toString();

        lazyInitialized = null;
        lazyInitialized.toString();

        //
        compare(5,4);

    }

    private static int compare(int x, int y) {
        return x < y ? x : null;
    }

}