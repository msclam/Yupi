package com.ljw.ObjectInputOutputStream;

import java.io.Serializable;

public class People implements Serializable {
    public static final long serialVersionUID = -5499016769898430454L;

    private String name;
    private int age;
    private Account account;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Account implements Serializable {
    private static final long serialVersionUID = -54990167698430454L;
}
