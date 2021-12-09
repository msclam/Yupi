package com.ljw.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UseReflection {
    @Test
    public void FieldTest() throws Exception {
        Class clazz = Person.class;

        Person p = (Person) clazz.newInstance();

        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);

        name.set(p, "abc");
//        name.set(Person.class, "abc");

        Object o = name.get(p);
    }

    @Test
    public void MethodTest() throws Exception {
        Class clazz = Person.class;

        Person p = (Person) clazz.newInstance();

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);

        showNation.setAccessible(true);

        showNation.invoke(p, "abc");

        System.out.println("===========================================");

        Method showStaticPrivate = clazz.getDeclaredMethod("showStaticPrivate");

        showStaticPrivate.setAccessible(true);

        showStaticPrivate.invoke(Person.class);


    }

    @Test
    public void ConstructorTest() throws Exception {
        // 调用运行时类中的指定的构造器
        Class clazz = Person.class;

        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

        declaredConstructor.setAccessible(true);

        Person p = (Person) declaredConstructor.newInstance("tom");

    }
}
