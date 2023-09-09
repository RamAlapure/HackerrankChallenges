package com.pluralsight.dp.mediator;

public class ColleagueB implements Colleague {

    private final Mediator mediator;

    public ColleagueB(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("ColleagueB received: " + message);
    }
}
