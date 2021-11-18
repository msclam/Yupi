package com.ljw.Test;

/**
 * @author lanjuwen
 * @create 2021-11-18  12:23
 */
public class MultiThreadPrintNums {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();
//                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
