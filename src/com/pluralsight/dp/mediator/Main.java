package com.pluralsight.dp.mediator;

public class Main {

    public static void main(String[] args) {
        MediatorImpl mediator = new MediatorImpl();
        ColleagueA colleagueA = new ColleagueA(mediator);
        mediator.setColleagueA(colleagueA);
        ColleagueB colleagueB = new ColleagueB(mediator);
        mediator.setColleagueB(colleagueB);

        colleagueA.sendMessage("Hi from A");
        colleagueB.sendMessage("Hi from B");
    }
}
