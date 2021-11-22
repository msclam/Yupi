package com.ljw.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lanjuwen
 * @create 2021-11-20  0:35
 */
public class ForEach {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(789);

        for (Object obj : coll) {
            System.out.println(obj);
        }

        int[] arr = new int[]{1, 2, 3};

        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void test1() {
        String[] arr = new String[] {"123", "123"};
//        for (int i = 0; i < arr.length; i ++ ) {
//            arr[i] = "666";
//        }

        for (String s : arr) {
            s = "acv";
        }

        for (String i : arr) {
            System.out.println(i);
        }
    }
}
