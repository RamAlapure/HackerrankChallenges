package com.pluralsight.jp.factory;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Factory<Circle> factory = Circle::new;

        Circle circle = factory.newInstance();
        System.out.println(circle);

        Factory<Circle> circle1 = Factory.create(Circle::new);
        System.out.println(circle1.newInstance());

        Factory<Circle> factory1 = Factory.create(Circle::new, Color.BLUE);
        System.out.println(factory1.newInstance());
    }
}
