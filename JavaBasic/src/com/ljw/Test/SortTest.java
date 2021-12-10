package com.ljw.Test;

import java.util.HashMap;
import java.util.Map;

public class SortTest {
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left - 1, j = right + 1;
        int x = nums[left];
        while (i < j) {
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    public static void qsort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l, j = r, x = nums[l + r >> 1];
        while (i < j) {
            while (nums[i] < x) i++;
            while (nums[j] > x) j--;
            if (i <= j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
        qsort(nums, l, j);
        qsort(nums, i, r);
    }

    public static void main(String[] args) {
//        int[] nums = {3, 1, 2, 4, 5};
//        qsort(nums, 0, nums.length - 1);
//        for (int i : nums) {
//            System.out.print(i + " ");
//        }
        int[] arr = {1, 2, 3};
        Map<Integer, Integer> mp = new HashMap<>();
        for (Integer i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
