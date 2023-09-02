package com.pluralsight.dp.facade;

public class DeliveryPerson {

    private final String name;

    public DeliveryPerson(String name) {
        this.name = name;
    }

    public void deliver() {
        System.out.println("Order delivered by " + name);
    }
}
