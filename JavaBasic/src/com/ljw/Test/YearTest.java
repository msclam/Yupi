package com.ljw.Test;

import java.util.Scanner;

/**
 * @author lanjuwen
 * @create 2021-10-17  16:59
 */
public class YearTest {
    public static void main(String[] args) {
        // year 年 month 月 day 天 是该年的第x天
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        int sumDay = 0;
        switch (m) {
            case 12:
                sumDay += 31;
            case 11:
                sumDay += 30;
            case 10:
                sumDay += 31;
            case 9:
                sumDay += 30;
            case 8:
                sumDay += 31;
            case 7:
                sumDay += 31;
            case 6:
                sumDay += 30;
            case 5:
                sumDay += 31;
            case 4:
                sumDay += 30;
            case 3:
                sumDay += 31;
            case 2:
                if ((y % 400 == 0) ||
                        (y % 4 == 0 && y % 100 != 0)) {
                    sumDay += 29;
                } else {
                    sumDay += 28;
                }
            case 1:
                sumDay += d;
        }
    }
}
