package com.ljw.reflection.exer;

@MyAnnotation(value = "yes")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation(value = "hi")
    private Person(String name) {
        this.name= name;
    }

    Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    @MyAnnotation
    private String show(String nation) {
        System.out.println(nation);
        return nation;
    }

    public String display(String interest) {
        return interest;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("i am human");
    }
}
