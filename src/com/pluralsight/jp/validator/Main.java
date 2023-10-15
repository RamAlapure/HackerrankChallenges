package com.pluralsight.jp.validator;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ram", 33);
        Person p2 = new Person(null, 0);

        Person person = personValidator(p1);
        System.out.println(person);
        person = personValidator(p2);
        System.out.println(person);
    }

    private static Person personValidator(Person p2) {
        return Validator.validate((Person p) -> p.name() != null, "Name should not be null")
                .thenValidate((Person p) -> p.age() > 0, "Age should be greater than 0")
                .thenValidate((Person p) -> p.age() < 0, "Age should be less than 150")
                .on(p2)
                .validate();
    }
}
