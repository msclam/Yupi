package com.hspedu.reflection.class_;

import com.hspedu.Car;

public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1 Class.forName  一般通过配置文件读取
        String classAllPath = "com.hspedu.Car";
        Class cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        // 2 类名.class，应用场景：多用于参数传递
        Class cls2 = Car.class;
        System.out.println(cls2);

        // 3 对象.getClass() 应用场景：右对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        // 4 通过类加载器（4种）来获得类的Class对象
        // (1)先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        // (2)通过类加载器得到Class对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        System.out.println(cls1.hashCode()); //1355531311
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        // 5 基本数据(int char boolean float double byte long short)
        // 按照如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);

        // 6 基本数据类型对应的包装类，通过.TYPE 得到Class类对象
        Class<Integer> cls6 = Integer.TYPE;
        System.out.println(integerClass.hashCode()); // 1555845260
        System.out.println(cls6.hashCode()); //1555845260

    }
}
