package com.ljw.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.stream.IntStream;

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
        // 反射创建对象(运行时类对象)
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

    @Test
    public void test5() {
        // 对于自定义类，系统类加载器进行加载
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        System.out.println(classLoader);

        // 调用系统类加载的getParent() 获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        // 扩展类加载器的getParent不能获得引导类加载器
        // 引导类加载器主要加载java核心类库，不能加载自定义类

    }

    @Test
    public void test6() {
        int[] nums = {0, -1, 99};
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
//        System.out.println(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

        nums = IntStream.of(nums).boxed().sorted(((o1, o2) -> o2 - o1)).mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test7() throws InstantiationException, IllegalAccessException {
        // 通过反射，创建运行时类的对象
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();
    }

    @Test
    public void test8() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.ljw.reflection.Person";
                break;
        }
        Object instance = getInstance(classPath);
        System.out.println(instance);
    }

    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
