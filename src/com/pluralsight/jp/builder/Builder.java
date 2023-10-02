package com.pluralsight.jp.builder;

import com.pluralsight.jp.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);
}
