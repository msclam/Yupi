package com.hspedu.reflection;

import com.hspedu.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection02 {
    /**
     * 测试反射调用性能和相关优化
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        m1();
        m2();
        m3();
    }
    // 传统方法调用hi
    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i ++ ) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("traditional way to invoke method hi: " + (end - start));
    }

    // 反射机制调用方法h1
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i ++ ) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("reflection way to invoke method hi: " + (end - start));
    }

    // 反射调用优化 + 关闭访问检查
    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true); // 在反射调用方法时，取消访问检查
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i ++ ) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("optimize reflection way to invoke method hi: " + (end - start));
    }
}
