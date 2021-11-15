package com.ljw.multiThread;

/**
 * @author lanjuwen
 * @create 2021-11-16  1:14
 */
public class RunnableImplTest {
    // 创建实现Runnable接口的类，重写抽象方法run
    // 将该类的对象作为参数传到Thread类的构造器中，创建Thread类对象，再调用start
    public static void main(String[] args) {
        MThread m1 = new MThread();

        Thread t1 = new Thread(m1);
        t1.start();

        Thread t2 = new Thread(m1);
        t2.start();
//        new Thread(m1).start();
    }
}

class MThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i ++ ) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
