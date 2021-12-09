package com.ljw.ProxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelief();
    void eat(String food);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("i can eat");
    }
}

class HumanUtil {
    public void method1() {
        System.out.println("通用方法一");
    }

    public void method2() {
        System.out.println("通用方法二");
    }
}

// 无代理类，根据被代理类动态生成代理类
/**
 * 根据加载到内存中的被代理类，动态创建代理类及其对象
 * 通过代理类的对象调用方法时，如何动态调用被代理类中的同名方法
 */
class ProxyFactory {
    // 返回一个代理类对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj; // 需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 通过代理类对象调用方法时，会自动调用如下方法 invoke，将被代理类执行的方法声明在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util = new HumanUtil();
//        util.method1();

        // 代理类对象调用方法，obj被代理类的对象
        Object returnValue = method.invoke(obj, args);

//        util.method2();

        return returnValue;
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("abc");

        System.out.println("==========");
        NikeClothFactory nikeClothFactory = new NikeClothFactory(); // 生成被代理类对象
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);// 动态生成代理类对象
        proxyClothFactory.produceCloth();
    }
}
