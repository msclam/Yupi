package com.hspedu.reflection.class_;

import com.hspedu.Cat;

/**
 * 对Class类特点的梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // Class类对象不是new出来的，而是系统创建的
        // （1） 传统new对象
        /*
         ClassLoad类 中的 loadClass方法
        * public Class<?> loadClass(String name) throws ClassNotFoundException {
              return loadClass(name, false);
          }
        * */
        Cat cat = new Cat();

        // （2） 反射方式  通过ClassLoad类加载Cat类的Class对象
        Class cls = Class.forName("com.hspedu.Cat");

        // 注意： 某个类的Class类对象只会加载一次
    }
}
