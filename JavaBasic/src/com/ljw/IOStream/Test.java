package com.ljw.IOStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author lanjuwen
 * @create 2021-12-03  0:49
 */
public class Test {
    public static void main(String[] args) {
//        int[] arr = new int[]{0, -99, 100};
        Integer[] arr = new Integer[]{0, -99, 100};
        Arrays.sort(arr, (a, b)-> b - a);
        System.out.println(Arrays.toString(arr));

        LinkedList<Integer> list = new LinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
//        list.remove();
//        System.out.println(list);
//        System.out.println(list.getFirst());
        list.push(4);
        System.out.println(list);
        list.pop();
        System.out.println(list);
    }
}
