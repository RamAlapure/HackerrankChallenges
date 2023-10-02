package com.pluralsight.jp.builder;

import java.util.StringJoiner;

public class Circle implements Shape {

    @Override
    public String toString() {
        return new StringJoiner(", ", Circle.class.getSimpleName() + "[", "]")
                .toString();
    }
}
