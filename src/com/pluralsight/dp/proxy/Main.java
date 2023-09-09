package com.pluralsight.dp.proxy;

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("abc.jpg");
        // The image is not loaded yet

        // When the display method is called, the image is loaded and displayed
        image.display();

        // Subsequent calls to display will use the already loaded image
        image.display();
    }
}
