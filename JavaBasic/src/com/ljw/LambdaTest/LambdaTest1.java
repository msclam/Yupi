package com.ljw.LambdaTest;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest1 {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("abc");
            }
        };

        r1.run();

        System.out.println("================");

        Runnable r2 = () -> System.out.println("cba");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int num = cmp.compare(12, 21);
        System.out.println(num);

        System.out.println("=====================");

        // lambda表达式的使用
        Comparator<Integer> cmp2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(cmp2.compare(21, 12));

        // 方法引用
        Comparator<Integer> cmp3 = Integer::compare;
        System.out.println(cmp3.compare(12, 23));
    }
}
