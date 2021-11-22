package com.ljw.Collection.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author lanjuwen
 * @create 2021-11-21  16:39
 */
public class HashSetTest {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(4);

        HashSet set = new HashSet();
        set.addAll(list);
        List list1 = new ArrayList(set);
        for (Object obj : list1) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='AA'}]

        p1.name = "CC";
        set.remove(p1); // [Person{id=1002, name='BB'}, Person{id=1001, name='CC'}]
        System.out.println(set);

        set.add(new Person(1001, "CC"));
        //[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='CC'}]
        System.out.println(set);
        set.add(new Person(1001, "AA"));
        //[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='CC'}, Person{id=1001, name='AA'}]
        System.out.println(set);

    }
}
