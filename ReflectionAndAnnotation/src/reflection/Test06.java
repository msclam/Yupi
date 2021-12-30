package reflection;

// 测试类什么时候会初始化
public class Test06 {
    static {
        System.out.println("Main类加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1 主动引用
//        Son son = new Son();

        // 反射也会发生类的初始化
//        Class<?> aClass = Class.forName("reflection.Son");

        // 2 被动引用（不会产生引用）
//        System.out.println(Son.b); // 父 子 b

//        Son[] arr = new Son[5]; // main

        System.out.println(Son.M);  // main M
    }
}

class Father {
    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}
