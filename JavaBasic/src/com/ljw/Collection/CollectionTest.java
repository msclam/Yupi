package com.ljw.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(false);
        coll.add(456);
        coll.add(new Person());

        System.out.println(coll);
        boolean contains = coll.contains(123);
        System.out.println(contains);
        coll.add(new Person("tom", 12));
        System.out.println(coll.contains(new String("tom"))); // 调用equals方法
        System.out.println(coll.contains(new Person("tom", 12)));
    }
}
