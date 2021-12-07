package com.ljw.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1() {
        // 包->类->对象->内部属性与方法 （不可以调用私有结构）
        Person p1 = new Person("tom", 12);
        p1.age = 10;
        System.out.println(p1);
        p1.show();
    }
    @Test
    public void test2() throws Exception {
        // 反射创建对象
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("a", 1);
        Person p = (Person) obj;
        System.out.println(p);

        // 反射调用属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(p, 2);
        System.out.println(p);

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
    }

    @Test
    public void test3() throws Exception {
        // 反射调用私有结构（属性、方法、构造器）
        Class clazz = Person.class;
        Constructor priCons = clazz.getDeclaredConstructor(String.class);
        priCons.setAccessible(true);
        Person p1 = (Person) priCons.newInstance("b");
        System.out.println(p1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "abc");
        System.out.println(p1);

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1, "nation");
    }

    @Test
    public void test4() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性
        Class<Person> clazz = Person.class;
        System.out.println(clazz);
        
        // 方式二： 调用运行时类对象的方法
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 方式三： 调用Class的静态方法forName(String classPath)
        Class clazz3 = Class.forName("com.ljw.reflection.Person");
        System.out.println(clazz3);

        // 方式四： 使用类的加载器ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.ljw.reflection.Person");
        System.out.println(clazz4);
    }
}
