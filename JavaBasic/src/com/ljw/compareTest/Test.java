package com.ljw.compareTest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lanjuwen
 * @create 2021-11-18  14:47
 */
public class Test {
    public static void main(String[] args) {
        Person p = new Person("a", 1);
        Person p2 = new Person("b", 2);
        Person[] pers = new Person[]{p, p2};
        Comparator<Person> cmp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        Arrays.sort(pers, cmp);
        System.out.println(Arrays.toString(pers));
    }
}
