package com.pluralsight.dp.mediator;

public class ColleagueA implements Colleague {
    private final Mediator mediator;

    public ColleagueA(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("ColleagueA received: " + message);
    }
}
