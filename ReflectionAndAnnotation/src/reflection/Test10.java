package reflection;

import java.lang.reflect.Method;

// 分析性能问题
public class Test10 {
    // 普通方式调用
    public static void test01() {
        User user = new User();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            user.getName();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    // 反射方式调用
    public static void test02() throws Exception {
        User user = new User();
        Class clazz = user.getClass();

        Method getName = clazz.getDeclaredMethod("getName", null);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(user, null);

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    // 反射方式调用 关闭检测
    public static void test03() throws Exception {
        User user = new User();
        Class clazz = user.getClass();

        Method getName = clazz.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(user, null);

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) throws Exception {
        test01();
        test02();
        test03();
    }
}
