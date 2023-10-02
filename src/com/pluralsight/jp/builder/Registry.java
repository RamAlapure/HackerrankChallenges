package com.pluralsight.jp.builder;

import com.pluralsight.jp.factory.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Registry<T> {

    Factory<? extends T> build(String shape);

    static <T> Registry<T> create(Consumer<Builder<T>> consumer, Function<String, Factory<T>> function) {
        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder = map::put;
        consumer.accept(builder);
        System.out.println("Map: " + map);
        return key -> map.computeIfAbsent(key, function);
    }
}
