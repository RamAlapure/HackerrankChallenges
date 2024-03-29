package com.pluralsight.jp.cc;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        functionalCompositionAndChainingWithComparator();

    }

    private static void functionalCompositionAndChainingWithComparator() {
        Person ram = new Person("Ram", 33);
        Person rahul = new Person("Rahul", 33);
        Person anvi = new Person("Anvi", 3);
        Person atharv = new Person("Atharv", 1);

        Comparator<Person> nameComparator = Comparator.comparing(Person::name);
        System.out.println("Rahul > Ram : " + (nameComparator.compare(rahul, ram) > 0));
        System.out.println("Atharv > Anvi : " + (nameComparator.compare(atharv, anvi) > 0));

        Comparator<Person> reversed = nameComparator.reversed();

        System.out.println("Rahul > Ram : " + (reversed.compare(rahul, ram) > 0));
        System.out.println("Atharv > Anvi : " + (reversed.compare(atharv, anvi) > 0));

        Comparator<Person> comparator = Comparator.comparing(Person::name).thenComparing(Person::age);
        System.out.println("Rahul > Ram : " + (comparator.compare(rahul, ram) > 0));
        System.out.println("Atharv > Anvi : " + (comparator.compare(atharv, anvi) > 0));
    }

    private static void methodChainingAndCompositionWithFunction() {
        Function<Meteo, Integer> tempInCelsius = Meteo::temp;
        Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d / 5d + 32d;
        Function<Meteo, Double> tempInFahrenheit = tempInCelsius.andThen(celsiusToFahrenheit);

        // this is method chaining
        Double value = tempInFahrenheit.apply(new Meteo(10));
        System.out.println(value);

        // this is method composition, and only possible with Function not with Consumer and Predicate
        tempInFahrenheit = celsiusToFahrenheit.compose(tempInCelsius);
        System.out.println(tempInFahrenheit.apply(new Meteo(10)));

        Function<String, String> f = Function.identity();
        System.out.println(f);
    }

    private static void methodChainingWithPredicate() {
        Predicate<String> p1 = Objects::isNull;
        Predicate<String> p2 = String::isEmpty;
        Predicate<String> p3 = p1.and(p2).negate();

        System.out.println(p3.test(""));
        System.out.println(p3.test("A"));
    }

    private static void methodChainingWithConsumer() {
        Consumer<String> c1 = s -> System.out.println("c1: " + s);
        Consumer<String> c2 = s -> System.out.println("c2: " + s);
        Consumer<String> c3 = c1.andThen(c2);
        c3.accept("Hi");
        //c3 = c1.andThen(null);
    }
}
