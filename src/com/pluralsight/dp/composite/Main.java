package com.pluralsight.dp.composite;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Folder c = new Folder("C drive");

        Folder documents = new Folder("documents");
        documents.add(new File("abc.txt"));

        Folder downloads = new Folder("downloads");
        downloads.add(new File("xyz.exe"));

        Folder users = new Folder("users");
        users.add(new Folder("Ram"));

        c.add(List.of(documents, downloads, users));

        c.display();
    }
}
