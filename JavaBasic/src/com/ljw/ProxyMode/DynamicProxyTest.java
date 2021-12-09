package com.ljw.ProxyMode;

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

public class DynamicProxyTest {
}
