package com.ljw.Collection.ListTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanjuwen
 * @create 2021-11-20  0:48
 */
public class ListTestCase {
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>(10);
//        System.out.println(list.size());
        for (int i = 0; i < 10; i ++ ) {
            list.add(i);
        }
        list.set(0, 1);
        for (int i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom", 12));
        list.add(456);

        System.out.println(list);

        list.add(1, "BB");
        System.out.println(list);

        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());

        System.out.println(list.get(1));

        System.out.println(list.indexOf(456));
        System.out.println(list.lastIndexOf(456));
    }
}
