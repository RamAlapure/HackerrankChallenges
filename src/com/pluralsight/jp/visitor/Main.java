package com.pluralsight.jp.visitor;

import com.pluralsight.jp.cc.Consumer;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        Body body = new Body();
        Engine engine = new Engine();

        Consumer<VisitorBuilder<String>> consumer = Visitor
                .<Car, String>forType(Car.class).execute((Car c) -> "Visiting car " + c)
                .forType(Body.class).execute((Body b) -> "Visiting body " + b)
                .forType(Engine.class).execute((Engine e) -> "Visiting engine " + e);

        Visitor<String> visitor = Visitor.of(consumer);

        String visited = visitor.visit(car);
        System.out.println("Car: " + visited);
        String bodyVisited = visitor.visit(body);
        System.out.println("Body: " + bodyVisited);
        String engineVisited = visitor.visit(engine);
        System.out.println("Engine: " + engineVisited);
    }
}
