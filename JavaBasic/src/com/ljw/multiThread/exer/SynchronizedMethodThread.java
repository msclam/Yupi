package com.ljw.multiThread.exer;

/**
 * @author lanjuwen
 * @create 2021-11-17  1:39
 */
public class SynchronizedMethodThread {
    public static void main(String[] args) {
        Window3 t1 = new Window3();
        Window3 t2 = new Window3();
        Window3 t3 = new Window3();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();  // static保证多个线程共用同一把锁

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show() {  
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
        }
    }
}

