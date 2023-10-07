package com.pluralsight.jp.visitor;

import com.pluralsight.jp.cc.Function;

public interface VisitorBuilder<R> {

    <T> void register(Class<T> type, Function<T, R> function);
}
