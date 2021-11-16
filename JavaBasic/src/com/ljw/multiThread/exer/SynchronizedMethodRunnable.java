package com.ljw.multiThread.exer;

/**
 * @author lanjuwen
 * @create 2021-11-17  1:32
 */
public class SynchronizedMethodRunnable {
    public static void main(String[] args) {
        Window2 w2 = new Window2();

        Thread t1 = new Thread(w2);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public synchronized void run() {  // 相当于this
        while (true) {
            show();
        }
    }

    private synchronized void show() {
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


