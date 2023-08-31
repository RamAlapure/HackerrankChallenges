package com.pluralsight.dp.state;

public class Vibrate implements State {
    @Override
    public void call() {
        System.out.println("In vibrate mode");
    }
}
