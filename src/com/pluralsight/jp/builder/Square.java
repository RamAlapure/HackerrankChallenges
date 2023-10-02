package com.pluralsight.jp.builder;

import java.util.StringJoiner;

public class Square implements Shape {

    @Override
    public String toString() {
        return new StringJoiner(", ", Square.class.getSimpleName() + "[", "]")
                .toString();
    }
}
