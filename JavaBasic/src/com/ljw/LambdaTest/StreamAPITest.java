package com.ljw.LambdaTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPITest {
    @Test
    public void test1() {
        // 1  通过集合创建stream
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Stream<Integer> stream = list.stream(); // 顺序流
        System.out.println(stream);

        Stream<Integer> parallelStream = list.parallelStream(); // 并行流

        int[] arr = {0, -9, 123};
//        IntStream arr1 = IntStream.of(arr);

//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
        arr = Arrays.stream(arr).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        // 2 通过数组创建stream
        int[] arr = new int[]{1, 2, 3};
        IntStream stream = Arrays.stream(arr);

        // 3 通过Stream.of创建
        IntStream arr1 = IntStream.of(arr);
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
    }

    @Test
    public void test3() {
        // 创建无限流
        // 迭代
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        // 生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void test4() {
        // 中间操作-筛选、切片
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(0);
        list.add(-99);
        Stream<Integer> stream = list.stream(); // 顺序流

        // 过滤流
//        list.stream().filter(a -> a > 0).forEach(System.out::println);
        // 截断流
//        list.stream().limit(2).forEach(System.out::println);
        // 跳过元素（跳过前n个）
//        list.stream().skip(2).forEach(System.out::println);
        // 去重
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test5() {
        // 中间操作-映射

    }

    @Test
    public void test6() {
        // 中间操作-排序

    }
}