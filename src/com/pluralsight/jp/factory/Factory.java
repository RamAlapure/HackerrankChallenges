package com.pluralsight.jp.factory;

import java.util.function.Function;
import java.util.function.Supplier;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    static <T> Factory<T> create(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <T, P> Factory<T> create(Function<P, T> function, P param) {
        return () -> function.apply(param);
    }
}
