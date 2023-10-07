package com.pluralsight.jp.visitor;

import java.util.StringJoiner;

public class Car {

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .toString();
    }
}
