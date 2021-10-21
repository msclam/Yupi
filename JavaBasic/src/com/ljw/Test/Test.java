package com.ljw.Test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        int[] A = {0, 99, -1, 0, 12, 4, 3, 123};
//        qSort(A, 0, A.length - 1);
//        for (int num : A) {
//            System.out.print(num + " ");
//        }
//        System.out.println();

//        int a = 12;
//        int b = -5;
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println(a + " " + b);
//
//        int c = 60;
//        System.out.println(Integer.toHexString(c));
//
//        int num = 14;
//        String str = num > 9 ? (char)(num - 10 + 'A') + "" : num + "";
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(n);
//
//        int rad = (int)(Math.random() * (b - a + 1) + a);

//        String[] s = new String[3];
//        for (int i = 0; i < s.length; i ++ ) {
//            s[i] = new String();
//            System.out.println(s[i]);
//        }
//        System.out.println(s[0]);

        int[] a = new int[6]; // 生成[1, 30]中的随机数，其中每个随机数不相同
        for (int i = 0; i < a.length; i ++ ) {
            a[i] = (int)(Math.random() * (30 - 1 + 1) + 1);
            for (int j = 0; j < i; j ++ ) {
                if (a[j] == a[i]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < a.length; i ++ ) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    public static void qSort(int[] A, int l, int r) {
        if (l >= r) return;
        int i = l, j = r, x = A[l + r >> 1];
        while (i < j) {
            while (A[i] < x) i++;
            while (A[j] > x) j--;
            if (i <= j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        if (l < j) qSort(A, l, j);
        if (i < r) qSort(A, i, r);
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}