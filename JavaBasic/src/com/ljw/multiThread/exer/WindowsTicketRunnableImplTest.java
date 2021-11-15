package com.ljw.multiThread.exer;

/**
 * @author lanjuwen
 * @create 2021-11-16  1:25
 */
public class WindowsTicketRunnableImplTest {
    public static void main(String[] args) {
        Window1 w1 = new Window1();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window1 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}


