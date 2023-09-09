package com.pluralsight.dp.mediator;

public class MediatorImpl implements Mediator {
    private ColleagueA colleagueA;
    private ColleagueB colleagueB;

    public void setColleagueA(ColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague.equals(colleagueA)) colleagueB.receiveMessage(message);
        else colleagueA.receiveMessage(message);
    }
}
