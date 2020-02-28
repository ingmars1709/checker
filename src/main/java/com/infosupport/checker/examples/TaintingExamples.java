package com.infosupport.checker.examples;

import org.checkerframework.checker.tainting.qual.Tainted;
import org.checkerframework.checker.tainting.qual.Untainted;

public class TaintingExamples {

    private void processRequest() {
        executeQuery(getUserName(), "");
    }

    private @Tainted String getUserName() {
        return "administrator'--";
    }

    private void executeQuery(final @Untainted String username, final @Untainted String password) {
        final String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";
        // execute injected SQL Query...
    }
}