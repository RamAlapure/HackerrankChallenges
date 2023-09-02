package com.pluralsight.dp.facade;

import java.util.List;

public class Restaurant {

    public void prepare(List<String> items) {
        System.out.println("Food prepared for items: " + items);
    }
}
