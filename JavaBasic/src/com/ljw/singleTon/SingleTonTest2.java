package com.ljw.singleTon;

public class SingleTonTest2 {
	public static void main(String[] args) {
		Order order1 = Order.getInstance();
		Order order2 = Order.getInstance();
		System.out.println(order1 == order2);
	}
}

// 懒汉式
class Order {
	// 1 私有化类构造器
	private Order() {
		
	}
	// 2 声明类对象，没有初始化
	private static Order instance = null;
	
	
	// 3 声明public static 的返回类对象的方法
	public static Order getInstance() {
		if (instance == null) {
			instance = new Order();
		}
		return instance;
	}
}
