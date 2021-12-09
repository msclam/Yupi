package com.ljw.ProxyMode;
// 接口
interface ClothFactory {
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory {
    // 用被代理类的对象进行实例化
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备");
        factory.produceCloth();
        System.out.println("代理工程收尾");
    }
}
// 被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("nike工厂生产一批运动服装");
    }
}

// 静态代理实现
public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nike = new NikeClothFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}
