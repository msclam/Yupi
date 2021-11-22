package com.ljw.Collection.MapTest;

/**
 * @author lanjuwen
 * @create 2021-11-22  0:27
 */
public class User implements Comparable {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
       if (o instanceof User) {
           User user = (User) o;
           if (this.getName().compareTo(user.getName()) != 0) {
               return -this.getName().compareTo(user.getName());
           } else {
                return Integer.compare(this.getAge(), user.getAge());
           }
       } else {
           throw new RuntimeException();
       }
    }
}
