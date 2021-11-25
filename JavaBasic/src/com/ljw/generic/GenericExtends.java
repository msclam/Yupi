package com.ljw.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lanjuwen
 * @create 2021-11-26  0:24
 */
public class GenericExtends {
    @Test
    public void test() {
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2;

        List<String> list3 = null;
        ArrayList<String> list4 = null;
        list3 = list4;
    }

    @Test
    public void test2() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        List<String> list3 = new ArrayList<>();
        list = list3;

//        list.add("a");

    }
    @Test
    public void test3() {
        // <=
        List<? extends Person> list1 = null;
        // >=
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

//        list1 = list3;
//        list1 = list4;
//        list1 = list5;

    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
