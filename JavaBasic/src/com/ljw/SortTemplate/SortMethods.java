package com.ljw.SortTemplate;

public class SortMethods {
    public static void main(String[] args) {
        int[] arr = {99, 0, -1, 2, 0, -9, 6, 1, 2, 3, 1};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

//        quickSort(arr, 0, arr.length - 1);
        quick_sort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int l, int r) {
        int x = arr[l];
        while (l < r) {
            while (l < r && arr[r] > x) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= x) l++;
            arr[r] = arr[l];
        }
        arr[l] = x;
        return l;
    }

    public static void quick_sort(int[] arr, int l, int r) {
        if (l < r) {
            int pos = partition(arr, l, r);
            quick_sort(arr, l, pos - 1);
            quick_sort(arr, pos + 1, r);
        }
    }
    /*
    快速排序
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r, x = arr[l + r >> 1];
        while (i < j) {
            while (arr[i] < x) i++;
            while (arr[j] > x) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (l < j) quickSort(arr, l, j);
        if (i < r) quickSort(arr, i, r);
    }
    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
