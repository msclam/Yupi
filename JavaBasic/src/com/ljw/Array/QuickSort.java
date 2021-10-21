package com.ljw.Array;

/**
 * @author lanjuwen
 * @create 2021-10-20  20:45
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] A = new int[] {0, 99, -6, 7, 89, 0, -123, 88};

//        quickSort(A, 0, A.length - 1);
        QuickSort(A, 0, A.length - 1);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public static int partition(int[] A, int l, int r) {
        int x = A[l];
        while (l < r) {
            while (l < r && A[r] > x) r--;
            A[l] = A[r];
            while (l < r && A[l] <= x) l++;
            A[r] = A[l];
        }
        A[l] = x;

        return l;
    }
    public static void QuickSort(int[] A, int l, int r) {
        if (l < r) {
            int pos = partition(A, l, r);
            QuickSort(A, l, pos - 1);
            QuickSort(A, pos + 1, r);
        }
    }

    public static void quickSort(int[] A, int l, int r) {
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
        if (l < j) quickSort(A, l, j);
        if (i < r) quickSort(A, i, r);
    }

    public static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
