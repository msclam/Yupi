package com.ljw.Test;

/**
 * @author lanjuwen
 * @create 2021-10-17  20:18
 */
public class JiuJiuChengfabiao {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i ++ ) {
            for (int j = 1; j <= i; j ++ ) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
