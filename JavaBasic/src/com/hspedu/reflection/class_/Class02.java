package com.hspedu.reflection.class_;

import com.hspedu.Car;

import java.lang.reflect.Field;

/**
 * 研究class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.hspedu.Car";
        // 1、获得加载类 对应的Class对象
        Class cls = Class.forName(classAllPath);
        // 2、输出cls  class com.hspedu.Car
        System.out.println(cls); // 显示cls对象，是那个类的Class对象
        // java.lang.Class
        System.out.println(cls.getClass()); // 输出cls的运行类型
        // 3、得到包名
        System.out.println(cls.getPackage().getName()); // 包名
        // 4、得到全类名
        System.out.println(cls.getName());
        // 5、通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);
        // 6、通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));
        System.out.println(brand.getName());
        // 7、通过反射给属性赋值
        brand.set(car, "cba");
        // 8、获取所有的字段属性
        Field[] fields = cls.getFields();
        for (Field f: fields) {
            System.out.println(f.getName());
        }

        Car c = new Car();
        System.out.println(Car.class);
        System.out.println(c.getClass());
        System.out.println(Class.forName(classAllPath));
    }
}
