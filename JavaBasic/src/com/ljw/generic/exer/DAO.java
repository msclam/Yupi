package com.ljw.generic.exer;

import java.util.List;

public class DAO<T> {
    // 泛型类的使用
    public void add(T t) {

    }

    public boolean remove(int index) {
        return false;
    }

    public void update(int index, T t) {

    }

    public T getIndex(int index) {
        return null;
    }

    public List<T> getForList(int index) {
        return null;
    }

    // 泛型方法的使用
    public <E> E getValue() {
        return null;
    }
}
