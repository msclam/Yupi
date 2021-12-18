package com.ljw.Test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        int[] A = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] B = {2, 5, 6};
//        int n = 3;
//        merge(A, m, B, n);
//
//        System.out.println(A.length);
//
//        for (int k : A) {
//            System.out.print(k + ",");
//        }

//        int[] A = {1, 2, 3, 0, 0, 0};
//        int[] res = {1, 2, 3, 4, 5, 6};
//
//        A = Arrays.copyOf(res, 6);
//        for (int k : A) {
//            System.out.print(k + ",");
//        }

//        String s = "[a, b, c]";
//        String[] str = s.substring(1, s.length() - 1).split(",");
//        for (String i : str) {
//            System.out.print(i + " ");
//        }
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int[] res = new int[m + n];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                res[idx++] = A[i++];
            } else {
                res[idx++] = B[j++];
            }
        }
        while (i < m) {
            res[idx++] = A[i++];
        }

        while (j < n) {
            res[idx++] = B[j++];
        }

        A = Arrays.copyOf(res, m + n);
        Queue<Integer> q = new LinkedList<>();

    }
}