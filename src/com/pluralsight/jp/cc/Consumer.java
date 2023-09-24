package com.pluralsight.jp.cc;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<T> other) {
        Objects.requireNonNull(other, "Consumer should not be null");
        return t -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
