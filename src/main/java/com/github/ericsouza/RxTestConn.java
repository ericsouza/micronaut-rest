package com.github.ericsouza;

import io.micronaut.context.annotation.Context;
import io.micronaut.r2dbc.rxjava2.RxConnectionFactory;


// just tests RxConnectionFactory is injectable
@Context
public class RxTestConn {
    private final RxConnectionFactory rxConnectionFactory;

    public RxTestConn(RxConnectionFactory rxConnectionFactory) {
        this.rxConnectionFactory = rxConnectionFactory;
    }
}