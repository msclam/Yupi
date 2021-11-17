package com.ljw.singleTon;

public class SingleTonTest1 {
	public static void main(String[] args) {
		// 单例设计模式：一个类只有一个实例对象
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		
		System.out.println(bank1 == bank2);
	}
}

// 饿汉式
class Bank {
	// 1 私有化类的构造器
	private Bank() {

	}

	// 2 内部创建类的对象, 4 此对象也是静态的
	private static Bank instance = new Bank();

	// 3 提供公共静态方法，返回类的对象
	public static Bank getInstance() {
		return instance;
	}
}