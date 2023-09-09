package com.pluralsight.dp.composite;

public abstract class FileSystemComponent {

    protected final String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    abstract void display();
}
