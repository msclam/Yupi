package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflection.User");

        User user = new User();
        Class<? extends User> aClass = user.getClass();

        // 获得类的名字
        System.out.println(c1.getName()); // 包+类
        System.out.println(c1.getSimpleName()); // 类

        System.out.println("==============================");

        // 获得类的属性
        Field[] fields = c1.getFields(); // 找到public的属性（包括父类）
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("==============================");

        // 获取全部属性
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println("==============================");

        // 获取指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("==============================");

        // 获取类的方法（本类和父类全部public）
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("==============================");

        // 获取本类所有方法
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("==============================");

        // 获取指定方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);

        System.out.println("==============================");

        // 获得指定的构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);
    }
}
