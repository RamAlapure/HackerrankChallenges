package com.pluralsight.jp.cc;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other, "Predicate should not be null");
        return t -> this.test(t) || other.test(t);
    }

    default Predicate<T> negate() {
        return t -> !this.test(t);
    }
}
