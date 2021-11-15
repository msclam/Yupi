package com.ljw.multiThread;

/**
 * @author lanjuwen
 * @create 2021-11-15  17:25
 */
public class ThreadExtendTest {
    /* 多线程的创建：
    * 一、继承Thread，然后重写run方法
    * new子类对象, .start()
    */
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        m1.start();
        m2.start();
//        myThread.run();
        for (int i = 0; i < 100; i ++ ) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + i + "******main******");
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i ++ ) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}