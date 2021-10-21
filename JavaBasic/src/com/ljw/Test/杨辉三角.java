package com.ljw.Test;

/**
 * @author lanjuwen
 * @create 2021-10-20  10:31
 */
public class 杨辉三角 {
    public static void main(String[] args) {
//        int[][] A = new int[10][];
//
//        for (int i = 0; i < A.length; i ++ ) {
//            A[i] = new int[i + 1];
//            A[i][0] = A[i][i] = 1;
//            for (int j = 1; j < A[i].length - 1; j ++ ) {
//                A[i][j] = A[i - 1][j - 1] + A[i - 1][j];
//            }
//        }
//
//        for (int i = 0; i < A.length; i ++ ) {
//            for (int j = 0; j < A[i].length; j ++ ) {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }

        int[][] B = new int[10][10];

        for (int i = 0; i < B.length; i ++ ) {
            for (int j = 0; j < i + 1; j ++ ) {
                B[i][0] = B[i][i] = 1;
                if (i >= 1 && j >= 1) {
                    B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
                }
            }
        }

        for (int i = 0; i < B.length; i ++ ) {
            for (int j = 0; j < i + 1; j ++ ) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
    }
}
