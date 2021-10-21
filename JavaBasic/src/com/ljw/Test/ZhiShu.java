package com.ljw.Test;

/**
 * @author lanjuwen
 * @create 2021-10-17  20:24
 */
public class ZhiShu {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        boolean flag = true;
        for (int i = 2; i < 10000; i ++ ) {
//            for (int j = 2; j < i; j ++ ) {
            for (int j = 2; j <= Math.sqrt(i); j ++ ) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
            flag = true;
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
