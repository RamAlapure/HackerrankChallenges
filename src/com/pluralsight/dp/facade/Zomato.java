package com.pluralsight.dp.facade;

import java.util.List;

public class Zomato {

    private final Restaurant restaurant;
    private final DeliveryPartner deliveryPartner;

    public Zomato() {
        this.restaurant = new Restaurant();
        this.deliveryPartner = new DeliveryPartner();
    }

    public void order(List<String> items) {
        // prepare food
        restaurant.prepare(items);
        // assign delivery partner
        DeliveryPerson deliveryPerson = deliveryPartner.assign();
        // deliver the items
        deliveryPerson.deliver();
    }
}
