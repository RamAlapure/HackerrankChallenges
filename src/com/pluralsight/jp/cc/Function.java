package com.pluralsight.jp.cc;

import java.util.Objects;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> other) {
        Objects.requireNonNull(other);
        return t -> other.apply(this.apply(t));
    }

    default <V> Function<V, R> compose(Function<V, T> other) {
        Objects.requireNonNull(other);
        return t -> this.apply(other.apply(t));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
