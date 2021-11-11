package com.hspedu.reflection.class_;

import java.io.Serializable;

/**
 * 演示哪些类型有Class对象
 */
public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class; // 外部类
        Class<Serializable> cls2 = Serializable.class; // 接口
        Class<Integer[]> cls3 = Integer[].class; // 数组
        Class<float[][]> cls4 = float[][].class;
        Class<Deprecated> cls5 = Deprecated.class; // 注解
        Class<Thread.State> cls6 = Thread.State.class; // 枚举
        Class<Void> cls7 = void.class;
        Class<Long> cls8 = long.class; // 基本数据类型
    }
}
