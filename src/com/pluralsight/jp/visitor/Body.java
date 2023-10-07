package com.pluralsight.jp.visitor;

import java.util.StringJoiner;

public class Body {

    @Override
    public String toString() {
        return new StringJoiner(", ", Body.class.getSimpleName() + "[", "]")
                .toString();
    }
}
