package com.ljw.Array;

/**
 * @author lanjuwen
 * @create 2021-10-20  14:11
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] A = new int[]{6, 5, 4, 3, 2, 1};

        // 复制
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i ++ ) {
            B[i] = A[i];
        }

        // 翻转数组
        int n = A.length;
//        for (int i = 0; i < n / 2; i ++ ) {
//            int t = A[i];
//            A[i] = A[n - i - 1];
//            A[n - i - 1] = t;
//        }

        for (int i = 0, j = n - 1; i < j; i ++, j -- ) {
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
        }

        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 线性查找
        String[] arr = new String[]{"aa", "bb", "cc", "dd"};
        String dest = "bb";

        boolean isFlag = true;

        for (int i = 0; i < arr.length; i ++ ) {
            if (dest.equals(arr[i])) {
                System.out.println("找到了指定元素: " + i);
                isFlag = false;
                break;
            }
        }
        if (isFlag) {
            System.out.println("没找到!");
        }

        int num = 6;
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (A[mid] == num) {
                System.out.println(mid);
                break;
            } else if (A[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }
}
