package com.pluralsight.dp.state;

public class Silent implements State {
    @Override
    public void call() {
        System.out.println("In silent mode");
    }
}
