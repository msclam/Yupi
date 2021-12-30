package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test09 {
    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class c1 = Class.forName("reflection.User");

        // 构造一个对象
        User user = (User) c1.newInstance(); // 本质上是调用无参构造器
        System.out.println(user);

        // 通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User usr = (User) constructor.newInstance("abc", 001, 19);
        System.out.println(usr);

        // 通过反射调用调用普通方法
        User usr2 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(usr2, "cba");
        System.out.println(usr2.getName());

        // 通过反射操作属性(不能直接操作私有的属性，需要关闭程序的安全检测，属性或方法setAccessible(true))
        User usr3 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(usr3, "guo");
        System.out.println(usr3.getName());
    }
}
