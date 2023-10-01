package com.pluralsight.jp.fr;

import java.util.function.Function;
import java.util.function.Supplier;

public interface Shape<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    static <T> Shape<T> create(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <T, P> Shape<T> create(Function<P, T> function, P param) {
        return () -> function.apply(param);
    }
}
