package com.pluralsight.jp.factory;

import java.awt.*;

public class Circle {

    private Color color;

    public Circle() {
    }

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" + "color=" + color +
                '}';
    }
}