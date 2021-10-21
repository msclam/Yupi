package com.ljw.Array;

/**
 * @author lanjuwen
 * @create 2021-10-20  20:21
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 0, -9, 6, 7};
        BubbleSort(A);

        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void BubbleSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i ++ ) {
            for (int j = 0; j < n - i - 1; j ++ ) {
                if (A[j] > A[j + 1]) {
                    int t = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = t;
                }
            }
        }
    }
}
