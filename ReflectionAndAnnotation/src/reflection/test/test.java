package reflection.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class test<T> {
    public static void main(String[] args) {
        Student student = new Student();
        Class clazz = student.getClass();
        // 获取父类的类型
        // getGenericSuperclass()用来获取当前类的父类的类型
        // ParameterizedType表示的是带泛型的类型
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        System.out.println(clazz.getGenericSuperclass());
        System.out.println(parameterizedType);
        System.out.println(types[0]);
    }
}
