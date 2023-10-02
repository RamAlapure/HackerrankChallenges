package com.pluralsight.jp.builder;

import com.pluralsight.jp.factory.Factory;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Consumer<Builder<Shape>> consumer1 = builder -> builder.register("circle", Circle::new);
        Consumer<Builder<Shape>> consumer2 = builder -> builder.register("triangle", Triangle::new);
        Consumer<Builder<Shape>> consumer3 = builder -> builder.register("square", Square::new);
        Consumer<Builder<Shape>> consumer = consumer1.andThen(consumer2).andThen(consumer3);

        Function<String, Factory<Shape>> function = k -> {
            throw new IllegalArgumentException("Unknown shape: " + k);
        };
        Registry<Shape> registry = Registry.create(consumer, function);

        Factory<? extends Shape> factory = registry.build("circle");
        Shape shape = factory.newInstance();
        System.out.println(shape);

        Factory<? extends Shape> squareFactory = registry.build("rectangle");
        squareFactory.newInstance();
    }
}
