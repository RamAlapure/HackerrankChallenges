package com.pluralsight.jp.fr;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Shape<Circle> shape = Circle::new;

        Circle circle = shape.newInstance();
        System.out.println(circle);

        Shape<Circle> circle1 = Shape.create(Circle::new);
        System.out.println(circle1.newInstance());

        Shape<Circle> shape1 = Shape.create(Circle::new, Color.BLUE);
        System.out.println(shape1.newInstance());
    }
}
