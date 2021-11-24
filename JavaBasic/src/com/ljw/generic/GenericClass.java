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
}
