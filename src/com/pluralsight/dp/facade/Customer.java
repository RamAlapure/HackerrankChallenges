package com.pluralsight.dp.facade;

import java.util.List;

public class Customer {

    public static void main(String[] args) {
        Zomato zomato = new Zomato();
        zomato.order(List.of("Biryani"));
    }
}
