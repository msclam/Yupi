package com.ljw.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        System.out.println(coll.isEmpty());
        // add
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(false);
        coll.add(456);
        coll.add(new Person());

        System.out.println(coll);
        // size
        System.out.println(coll.size());

        // addAll
        Collection coll1 = new ArrayList();
        coll1.add("9090");
        coll1.add("1024");
        coll.addAll(coll1);
        System.out.println(coll);

        // isEmpty()
        System.out.println(coll.isEmpty());

        // clear()
        coll.clear();
        System.out.println(coll.isEmpty());
        boolean contains = coll.contains(123);
        System.out.println(contains);
        coll.add(new Person("tom", 12));
        System.out.println(coll.contains(new String("tom"))); // 调用equals方法
        System.out.println(coll.contains(new Person("tom", 12)));
    }
}
