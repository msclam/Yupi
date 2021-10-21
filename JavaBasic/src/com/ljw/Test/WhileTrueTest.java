package com.ljw.Test;

import java.util.Scanner;

/**
 * @author lanjuwen
 * @create 2021-10-17  20:00
 */
public class WhileTrueTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cntNeg = 0;
        int cntPost = 0;
        while (true) {
            int num = sc.nextInt();
            if (num > 0) {
                cntPost++;
            } else if (num < 0) {
                cntNeg++;
            } else {
                break;
            }
        }
        System.out.println("cntNeg: " + cntNeg);
        System.out.println("cntPost " + cntPost);
    }
}
