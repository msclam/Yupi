package com.ljw.multiThread;

/**
 * @author lanjuwen
 * @create 2021-11-16  0:03
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();
        h1.setName("线程一");
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        Thread.currentThread().setName("主线程");
        System.out.println(h1.isAlive());
        for (int i = 0; i < 100; i ++ ) {
            System.out.println(Thread.currentThread().getName() + ":" + i + ":" + Thread.currentThread().getPriority());
            if (i == 20) {
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(h1.isAlive());
    }
}

class HelloThread extends Thread {
    public HelloThread() {

    }

    public HelloThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i ++ ) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + ":" + getPriority());
            }
//            if (i % 20 == 0) {
//                this.yield(); // 释放cpu执行权力
//            }
        }
    }
}
