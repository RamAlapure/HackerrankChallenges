package com.pluralsight.jp.visitor;

import com.pluralsight.jp.cc.Consumer;
import com.pluralsight.jp.cc.Function;

import java.util.HashMap;
import java.util.Map;

public interface Visitor<R> {

    R visit(Object object);

    static <T, R> X<T, R> forType(Class<T> type) {
        return () -> type;
    }

    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer) {
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        VisitorBuilder<R> visitorBuilder = new VisitorBuilder<>() {
            @Override
            public <T> void register(Class<T> type, Function<T, R> function) {
                registry.put(type, function.compose(type::cast));
            }
        };
        consumer.accept(visitorBuilder);
        System.out.println("Registered: " + registry.keySet());
        return object -> registry.get(object.getClass()).apply(object);
    }

    interface X<T, R> {

        Class<T> type();

        default Y<R> execute(Function<T, R> function) {
            return visitorBuilder -> visitorBuilder.register(type(), function);
        }
    }

    interface Y<R> extends Consumer<VisitorBuilder<R>> {

        default <T> Z<T, R> forType(Class<T> type) {
            return index -> index == 0 ? this : type;
        }

        default Y<R> andThen(Y<R> after) {
            return t -> {
                this.accept(t);
                after.accept(t);
            };
        }
    }

    interface Z<T, R> {
        Object get(int index);

        default Class<T> type() {
            return (Class<T>) get(1);
        }

        default Y<R> previousConsumer() {
            return (Y<R>) get(0);
        }

        default Y<R> execute(Function<T, R> function) {
            return previousConsumer().andThen(rVisitorBuilder -> rVisitorBuilder.register(type(), function));
        }
    }

}
