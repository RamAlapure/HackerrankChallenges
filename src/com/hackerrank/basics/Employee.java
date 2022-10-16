package com.hackerrank.basics;

import java.io.*;
import java.util.*;

public class Employee implements Comparable<Employee> {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Employee o) {
        int nameResult = name.compareTo(o.name); // sorting by name
        if (nameResult == 0) {
            return Integer.compare(this.age, o.age);
        }
        return nameResult;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }

    public static void main(String[] args) {
        Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ram", 30));
        employees.add(new Employee("Akshay", 26));
        employees.add(new Employee("Sanjay", 28));
        employees.add(new Employee("Rahul", 30));

        System.out.println(employees);

        //Collections.sort(employees);

        employees.sort(employeeComparator.reversed());
        System.out.println(employees);

    }

    // Serialization code
    static void serialize(Employee empObj) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("data.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(empObj);
        }
    }

    // Deserialization code
    static Employee deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("data.obj");
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (Employee) ois.readObject();
        }
    }

    // Custom serialization logic,
    // This will allow us to have additional serialization logic on top of the default one e.g. encrypting object before serialization
    private void writeObject(ObjectOutputStream oos) throws IOException {
        System.out.println("Custom serialization logic invoked.");
        oos.defaultWriteObject(); // Calling the default serialization logic
    }

    // Custom deserialization logic
    // This will allow us to have additional deserialization logic on top of the default one e.g. decrypting object after deserialization
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        System.out.println("Custom deserialization logic invoked.");

        ois.defaultReadObject(); // Calling the default deserialization logic

        // Age validation is just an example but there might some scenario where we might need to write some custom deserialization logic
        //validateAge();
    }
}
