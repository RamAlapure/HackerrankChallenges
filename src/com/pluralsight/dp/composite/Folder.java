package com.pluralsight.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent {

    private final List<FileSystemComponent> fileSystemComponents;

    public Folder(String name) {
        super(name);
        fileSystemComponents = new ArrayList<>();
    }

    public void add(List<FileSystemComponent> fileSystemComponents) {
        this.fileSystemComponents.addAll(fileSystemComponents);
    }

    public void add(FileSystemComponent fileSystemComponent) {
        this.fileSystemComponents.add(fileSystemComponent);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);
        fileSystemComponents.forEach(FileSystemComponent::display);
    }
}
