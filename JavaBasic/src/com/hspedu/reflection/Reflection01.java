package com.hspedu.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    /**
     * 测试反射的相关类
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 1 Properties类读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("JavaBasic\\src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        // 2 加载类，获得Class类型对象
        Class cls = Class.forName(classfullpath); // 加载类，获得Class类型的对象
        Object o = cls.newInstance();  // 通过cls获得加载类的对象实例
        System.out.println(o.getClass());

        // 3 java.lang.reflect.Method 代表类的方法， cls获得加载类的方法对象
        Method method1 = cls.getMethod(methodName); // 通过cls获得加载类的（方法名：x）方法对象（method对象）
        method1.invoke(o);  // 传统方法：对象.方法   反射机制： 方法对象.invoke(对象)

        // 4 java.lang.reflect.Field 代表类的成员变量，Field对象表示某个类的成员变量
        Field nameField = cls.getField("age"); // getField不能得到私有属性
        System.out.println(nameField.get(o)); // 成员变量对象.get(对象)


        // 5 java.lang.reflect.Constructor 代表类的构造方法， Constructor对象表示构造器
        Constructor constructor = cls.getConstructor(); // ()中可以指定构造器参数类型，返回无参构造器
        System.out.println(constructor);

        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
