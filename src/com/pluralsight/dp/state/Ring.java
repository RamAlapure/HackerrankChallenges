package com.pluralsight.dp.state;

public class Ring implements State {
    @Override
    public void call() {
        System.out.println("In ring mode");
    }
}
