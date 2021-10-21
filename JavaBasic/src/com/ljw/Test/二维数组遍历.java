package com.ljw.Test;

/**
 * @author lanjuwen
 * @create 2021-10-20  9:53
 */
public class 二维数组遍历 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {2, 3, 4, 5}, {9, 8}};


        for (int i = 0; i < arr.length; i ++ ) {
            for (int j = 0; j < arr[i].length; j ++ ) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
