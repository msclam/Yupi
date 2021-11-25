package com.ljw.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericClass<T> {
    String A;

    T orderT; // 类的内部结构可以使用类的泛型

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Test
    public void test() {
        GenericClass<String> gc = new GenericClass<>();
        gc.setOrderT("abc");
        gc.getOrderT();
    }

    // 泛型方法
    public <E> List<E> copyFromArray(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : list) {
            list.add(e);
        }
        return list;
    }

    public static <E> List<E> copyFromArray1(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : list) {
            list.add(e);
        }
        return list;
    }

    @Test
    public void test1() {
        GenericClass<String> order = new GenericClass<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        List<Integer> integers = order.copyFromArray(arr);
        System.out.println(integers);
    }

//    @Test
    // 静态方法不能使用类的泛型
//    public static void show(T orderT) {
//        System.out.println(orderT);
//    }

    // 异常类不能是泛型
//    public void show() {
//        try {
//
//        } catch (T orderT) {
//
//        }
//    }

    public void show() {
        T[] arr = (T[]) new Object[10];
    }


}
