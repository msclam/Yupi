package com.ljw.reflection.exer;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class GetRuntimeClassTest {
    @Test
    // 获取运行时类的属性结构及其内部结构
    public void FieldTest() {
        Class clazz = Person.class;

        // 获取属性结构
        // getFields (获取当前运行时类及其父类的public权限的属性)
        Field[] fields = clazz.getFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }

        // getDeclaredFields (获取当前运行类的所有属性，不包含父类）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    @Test
    // 获取权限修饰符 数据类型 变量名字
    public void FieldInnerTest() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            // 权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // 数据类型
            Class type = field.getType();
            System.out.print(type.getName() + "\t");

            // 变量名
            String name = field.getName();
            System.out.println(name);
        }
    }

    @Test
    public void MethodTest() {
        // 获取运行时类的方法结构(获取当前及其父类的所有public的权限的方法)
        Class clazz = Person.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        // 获取运行类中声明的所有方法，不包含父类的方法
        Method[] declareMethods = clazz.getDeclaredMethods();
        for (Method m : declareMethods) {
            System.out.println(m);
        }
    }

    @Test
    public void MethodInnerTest() {
        /**
         * @X
         * 权限修饰符 返回值类型 方法名（参数列表 形参）
         */
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // 获取方法声明的注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }

            // 权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");

            // 返回值类型
            System.out.print(method.getReturnType().getName() + "\t");

            // 方法名字
            System.out.print(method.getName() + "\t");

            // 形参
            System.out.print("(");
            Class[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i ++ ) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.print(")");

            // 异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (!(exceptionTypes == null & exceptionTypes.length == 0)) {
                System.out.println("throws");
                for (int i = 0; i < exceptionTypes.length; i ++ ) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void ConstructorsTest() {
        Class clazz = Person.class;
        // 当前运行时类的构造器public
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }

    @Test
    public void SuperClassTest() {
        Class clazz = Person.class;
        // 获取运行时类的父类
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

        // 获取运行时类的带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取运行时类的带泛型父类的泛型类型
        ParameterizedType parameType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    @Test
    public void interfaceTest() {
        // 获取运行类实现的接口
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        clazz.getSuperclass().getInterfaces();
    }

    @Test
    public void ClassAnnotations() {
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
    }
}
