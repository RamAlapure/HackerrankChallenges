package com.pluralsight.dp.state;


public class Phone {

    private State state;

    public Phone() {
        this.state = new Ring();
    }

    public void call() {
        state.call();
    }

    public void setState(State state) {
        this.state = state;
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.call();

        phone.setState(new Silent());
        phone.call();

        phone.setState(new Vibrate());
        phone.call();
    }
}
