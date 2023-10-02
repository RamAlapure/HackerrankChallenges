package com.pluralsight.jp.builder;

import java.util.StringJoiner;

public class Triangle implements Shape {

    @Override
    public String toString() {
        return new StringJoiner(", ", Triangle.class.getSimpleName() + "[", "]")
                .toString();
    }
}
