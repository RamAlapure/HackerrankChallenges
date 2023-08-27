package com.pluralsight;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaFundamentals {

    public static void main(String[] args) throws IOException {
//        main1();
//        extracted();
//        extracted1();
//        extracted2();
//        extracted3();
        //String s = "asd";
//        extracted4();
        BlockingQueue<String> bq = new LinkedBlockingQueue<String>(4);
        System.out.println(bq.poll());
        int i1 = 40_000;
    }

    private static void extracted4() {
        byte byte1 = 1;
        byte byte2 = 2;
        var sum = byte1 + byte2;
        System.out.println(sum);
    }


    private static void extracted3() {
        int myInt = 2;
        float myFloat = 3.8f;
        double myDouble = 2.9;
        char myChar = 'P';
    }

    private static void extracted2() {
        String myText = " Hello world";
        System.out.println(myText.substring(0, 3).toUpperCase().trim());
    }


    private static void extracted1() {
        int i = 2;
        int result = -1;
        switch(i) {
            case 1: result = 1;
                break;
            case 2: result = 2;
            case 3: result = 3;
            case 4: result = 4;
        }
        System.out.println("result = " + result);
    }

    private static void extracted() {
        int i = 0;
        increment(i);
        i++;
        System.out.println(i);
    }


    private static void increment(int i) {
        i++;
    }

    private static void sum(List<Double> list) {
        double sum = 0.0;
        for (double d : list) {
            if (Double.isFinite(d)) sum += d;
        }
    }

    public static void main1() throws IOException {
        String result = tryToReadFile();
        System.out.println("result = " + result);
    }

    public static void readFile() throws IOException {
        throw new IOException("IOException");
    }

    public static String tryToReadFile() throws IOException {
        try {
            readFile();
            return "try";
        } catch (IOException e) {
            return "catch";
        } finally {
            return "finally";
        }
    }
}

abstract class AbstractTesting {
    public abstract int size();

    public boolean isEmpty() {
        return size() == 0;
    }
    public AbstractTesting() {

    }
}

class Holder {

    protected int size = 10;

    public Holder() {

    }

    public Holder(int size) {
        this.size = size;
    }

    public int getSize() {
        return 10;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class ExtendedHolder extends Holder {

    private static final int SIZE = 30;

    private final int size = 20;

    public ExtendedHolder() {
        System.out.println(SIZE);
    }

    public int getSize() {
        return this.size;
    }
}

interface A {
    default int size() {
        return 10;
    }
}

interface B extends A {
    int size();
}
