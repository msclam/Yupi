package com.ljw.singleTonThreadSafe;

/**
 * @author lanjuwen
 * @create 2021-11-17  15:16
 */
public class BankTest {
}

class Bank {
    private Bank() {

    }

    private static Bank instance = null;

//    public static synchronized Bank getInstance() { // Bank.class
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;
//    }

    public static Bank getInstance() { // Bank.class
        // 效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

