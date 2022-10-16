package com.hackerrank.basics;

import java.util.HashSet;

public class Customer {

    String name;
    int age;

    // public static final int a; compile time error

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("John", 20);
        Customer c2 = new Customer("John", 20);

        HashSet<Customer> set = new HashSet<>();
        set.add(c1);
        set.add(c2);
        System.out.println(set.size());

        Customer c3 = c1;

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));

        A a = new B();

        // a.m2(); compile time error

        // Helper help = new Helper(); compile time error

        Integer x = 1000, y = 1000;
        System.out.println(x == y); // false

        Integer c = 100, d = 100;
        System.out.println(c == d); // true

        Test1 t1;

        // System.out.println(t1.i); // compile time error
    }
}

class A {

    void m1() {
        System.out.println("In m1 A");
    }
}

class B extends A {

    void m1() {
        System.out.println("In m1 B");
    }

    void m2() {
        System.out.println("In m2 B");
    }
}

class Helper {

    private int data;

    private Helper() {
        data = 5;
    }
}

class Test1 {
    int i;
}