package com.ljw.multiThread.exer;

/**
 * @author lanjuwen
 * @create 2021-11-16  0:52
 */
public class WindowsTicketsExtendsThread {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();  // static保证多个线程共用同一把锁
    @Override
    public void run() {
        while (true) {
            synchronized(Window.class) {
//            synchronized(obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
