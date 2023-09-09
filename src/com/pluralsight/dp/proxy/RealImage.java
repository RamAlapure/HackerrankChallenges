package com.pluralsight.dp.proxy;

public class RealImage implements Image {

    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename);
        // Perform actual loading from disk
    }

    @Override
    public void display() {
        System.out.println("Display real image: " + filename);
    }
}
