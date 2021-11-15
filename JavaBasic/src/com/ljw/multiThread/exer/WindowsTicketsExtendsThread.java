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

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ":" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}
