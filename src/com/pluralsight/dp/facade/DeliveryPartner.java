package com.pluralsight.dp.facade;

public class DeliveryPartner {

    public DeliveryPerson assign() {
        System.out.println("Delivery partner assigned");
        return new DeliveryPerson("ABC");
    }
}
