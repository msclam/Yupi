package com.ljw.Collection;

import org.junit.Test;

import java.util.*;

/**
 * @author lanjuwen
 * @create 2021-11-22  1:24
 */
public class CollectionsTest {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }

    @Test
    public void test1() {
//        List list = new ArrayList();
//        list.add(123);
//        list.add(43);
//        list.add(765);
//        list.add(-97);
//        list.add(0);
//
//        List list1 = Arrays.asList(new Integer[list.size()]);
//        System.out.println(list1);
//
//        Collections.copy(list1, list);
//        System.out.println(list1);

        int[] arr = new int[]{0, -1, 9};
//        Arrays.sort(arr, (a, b)-> a - b);
    }
}
