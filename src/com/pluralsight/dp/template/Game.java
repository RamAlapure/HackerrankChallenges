package com.pluralsight.dp.template;

public abstract class Game {

    abstract void init();

    abstract void start();

    abstract void end();
}


class Cricket extends Game {

    @Override
    void init() {
        System.out.println("Cricket initialized");
    }

    @Override
    void start() {
        System.out.println("Cricket match started");
    }

    @Override
    void end() {
        System.out.println("Cricket match ended");
    }
}

class Football extends Game {

    @Override
    void init() {
        System.out.println("Football initialized");
    }

    @Override
    void start() {
        System.out.println("Football match started");
    }

    @Override
    void end() {
        System.out.println("Football match ended");
    }
}