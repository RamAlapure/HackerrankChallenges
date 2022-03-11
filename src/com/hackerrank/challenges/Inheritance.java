package com.hackerrank.challenges;

class A {

    public void m1(){
        System.out.println("A - m1");
    }
}

class B extends A {

    public void m1() {
        System.out.println("B - m1");
    }

    public void m2() {
        System.out.println("B - m1");
    }
}

public class Inheritance {
    A a = new B();

}

