package com.pluralsight.dp.builder;

public class Main {

    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .foundation("foundation").structure("structure").roof("roof").interior("interior").build();
        System.out.println(house);
    }
}
