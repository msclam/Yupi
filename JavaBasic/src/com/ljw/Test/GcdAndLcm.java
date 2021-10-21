package com.ljw.Test;

import java.util.Scanner;

/**
 * @author lanjuwen
 * @create 2021-10-17  19:45
 */
public class GcdAndLcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
