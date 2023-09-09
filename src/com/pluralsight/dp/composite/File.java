package com.pluralsight.dp.composite;

public class File extends FileSystemComponent {

    public File(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}
