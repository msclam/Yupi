package com.ljw.reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null) return false;
        int five = 0, ten = 0, twenty = 0;
        for (int i = 0; i <bills.length; i ++ ) {
            if (bills[i] == 5) {
                five++;
            }
            if (bills[i] == 10) {
                if (five < 0) return false;
                five--;
                ten++;
            }
            if (bills[i] == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                    twenty++;
                } else if (five >= 3) {
                    five -= 3;
                    twenty++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] arr = {5, 5, 5, 10, 20};
//        boolean res = new Solution().lemonadeChange(arr);
//        System.out.println(res);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Integer[] integers = list.toArray(new Integer[list.size()]);

        Arrays.asList(new Integer[]{1, 2, 3});
    }
}
